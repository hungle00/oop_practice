class Painting
  attr_reader :title, :price, :artist, :gallery
  @@all = []

  def initialize(title, price, artist, gallery)
    @title = title
    @price = price
    @artist = artist
    @gallery = gallery
    @@all << self
  end

  def self.all
    @@all
  end

  def self.total_price
    Painting.all.map { |p| p.price }.sum
  end
end

class Artist
  attr_reader :name, :years_exp
  @@all = []

  def initialize(name, years_exp)
    @name = name
    @years_exp = years_exp
    @@all << self
  end

  def self.all
    @@all
  end

  def paintings
    Painting.all.select{ |p| p.artist = self}
  end

  def galleries
    self.paintings.map{ |p| p.gallery }.uniq
  end

  def cities
    self.galleries.map{ |g| g.city }.uniq
  end

  def create_painting(title, price, gallery)
    Painting.new("#{title}", "#{price}", self, "#{gallery}")
  end
end

class Gallery
  attr_reader :name, :city

  @@all = []

  def initialize(name, city)
    @name = name
    @city = city
    @@all << self
  end

  def self.all
    @@all
  end

  def paintings
    Painting.all.select{ |p| p.gallery == self}
  end

  def artists
    self.paintings.map{ |p| p.artist }.uniq
  end

  def artist_names
    self.paintings.map { |p| p.artist.name }.uniq
  end

  def most_expensive_painting
    self.paintings.max_by { |p| p.price }
  end
end

ben = Artist.new("Ben", 1)
maggie = Artist.new("Maggie", 9)

fra = Gallery.new("FRA", "New York")
buckets = Gallery.new("Galerie Buckets", "Cologne")

shark_tonk_2 = Painting.new("Shark Tonk II", 5000, ben, fra)
shark_tonk = Painting.new("Shark Tonk", 5000, ben, fra)
heart_fountain = Painting.new("Heart Fountain", 10000, maggie, buckets)
unhappy_break_up = Painting.new("Unhappy Break Up", 12000, maggie, buckets)
unhappy_break_up_2 = Painting.new("Unhappy Break Up II", 12000, maggie, fra)
#tile = Painting.new("Tile", 6000, maggie, buckets)

#ben.create_painting("Happy", 4000, buckets)

p Painting.total_price

p fra.most_expensive_painting