class CompactDisc {
  public String mArtist;
  public String mAlbum;
  public Integer mYear;
  public Integer mPrice;

  public CompactDisc(String artist, String album, int year, int price) {
    mArtist = artist;
    mAlbum = album;
    mYear = year;
    mPrice = price;
  }

  public boolean withinBudget(int maxPrice){
    return (mPrice <= maxPrice);
  }
}
