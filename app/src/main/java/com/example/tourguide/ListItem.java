package com.example.tourguide;

public class ListItem {

    //Member variables

    //text content describing the item in the card
    private String mItemTitle;

    //Image representing the item in the card
    private int mImageResourceId;

    //Google maps URL for the place
    private String map_URL;

    //Description of the place
    private String mItemDescription;

    /**
     * Create a new ListItem object
     *
     * @param itemTitle         gives us the name of place
     * @param representingImage gives us the corresponding image
     * @param map_url           gives us the url of ggogle maps for the corresponding place
     * @param itemDescription   gives us the text describing the place
     */

    public ListItem(String itemTitle, int representingImage, String map_url, String itemDescription) {
        mItemTitle = itemTitle;
        mImageResourceId = representingImage;
        map_URL = map_url;
        mItemDescription = itemDescription;
    }

    //Methods

    public String getMap_URL() {
        return map_URL;
    }

    public String getmItemDescription() {
        return mItemDescription;
    }

    public String getmItemTitle() {
        return mItemTitle;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }
}
