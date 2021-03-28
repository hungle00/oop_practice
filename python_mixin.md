## Mixin in python

> A mixin is a class which has no data, only methods. For this reason mixins normally don't have an __init__() and any class that inherits a mixin does not need to use super() to call the mixin's __init__()

```
class DistanceToMixin:
    def distance_to_origin(self):
        return math.hypot(self.x, self.y)
    def distance_to(self, other):
        return math.hypot(self.x - other.x, self.y - other.y)

class PointD(DistanceToMixin):
    __slots__ = ("x", "y")
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y
    def manhattan_length(self, other=None):
        if other is None:
            other = self.__class__() # Point(0, 0)
        return math.fabs(self.x - other.x) + math.fabs(self.y - other.y)
```
Although Python supports multiple inheritance, this feature is best avoided since it can greatly complicate code and result in subtle bugs (which is why Java doesn't allow it). However, in the case of mixins, because they hold no data, it is safe to multiply inherit as many mixins as we like — and up to one normal class too. For example:

```
class MoveMixin:
    def move_up(self, distance):
        self.y -= distance
    def move_down(self, distance):
        self.y += distance
    def move_left(self, distance):
        self.x -= distance
    def move_right(self, distance):
        self.x += distance
    def move_by(self, dx, dy):
        self.x += dx
        self.y += dy

class PointDM(DistanceToMixin, MoveMixin):
    __slots__ = ("x", "y")
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y
    def manhattan_length(self, other=None):
        if other is None:
            other = self.__class__() # Point(0, 0)
        return math.fabs(self.x - other.x) + math.fabs(self.y - other.y)

class CircleA2DM(DistanceToMixin, MoveMixin):
    def __init__(self, x=0, y=0, radius=1):
        self._point = PointDM(x, y)
        self.radius = radius
    def edge_to_origin(self):
        return self._point.distance_to_origin() - self.radius
    def __getattr__(self, name):
	return getattr(self._point, name)
    def __setattr__(self, name, value):
        if name in {"x", "y"}:
            setattr(self._point, name, value)
        else:
            super().__setattr__(name, value)
```

### Use decorator class for mixin

    def add_methods(*methods):
        def decorator(Class):
            for method in methods:
                setattr(Class, method.__name__, method)
            return Class
        return decorator


    def distance_to_origin(self):
        return math.hypot(self.x, self.y)

    def distance_to(self, other):
        return math.hypot(self.x - other.x, self.y - other.y)

    def move_up(self, distance):
        self.y -= distance

    def move_down(self, distance):
        self.y += distance

    def move_left(self, distance):
        self.x -= distance

    def move_right(self, distance):
        self.x += distance

    def move_by(self, dx, dy):
        self.x += dx
        self.y += dy


    @add_methods(distance_to_origin, distance_to, move_up,
                 move_down, move_left, move_right, move_by)
    class Point2:
        __slots__ = ("x", "y")
        def __init__(self, x=0, y=0):
            self.x = x
            self.y = y
        def manhattan_length(self, other=None):
            if other is None:
                other = self.__class__() # Point(0, 0)
            return math.fabs(self.x - other.x) + math.fabs(self.y - other.y)


    @add_methods(distance_to_origin, distance_to, move_up,
                 move_down, move_left, move_right, move_by)
    class Circle2:
        def __init__(self, x=0, y=0, radius=1):
            self._point = Point2(x, y)
            self.radius = radius

        def edge_to_origin(self):
            return self._point.distance_to_origin() - self.radius

        def __getattr__(self, name):
          return getattr(self._point, name)

        def __setattr__(self, name, value):
            if name in {"x", "y"}:
                setattr(self._point, name, value)
            else:
                super().__setattr__(name, value)