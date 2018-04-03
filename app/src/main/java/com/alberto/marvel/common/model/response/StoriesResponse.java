
package com.alberto.marvel.common.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.alberto.marvel.common.model.Story;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StoriesResponse implements Parcelable {

    @JsonProperty("available")
    private String available;
    @JsonProperty("returned")
    private String returned;
    @JsonProperty("collectionURI")
    private String collectionURI;
    @JsonProperty("items")
    private List<Story> items = null;

    @JsonProperty("available")
    public String getAvailable() {
        return available;
    }

    @JsonProperty("available")
    public void setAvailable(String available) {
        this.available = available;
    }

    @JsonProperty("returned")
    public String getReturned() {
        return returned;
    }

    @JsonProperty("returned")
    public void setReturned(String returned) {
        this.returned = returned;
    }

    @JsonProperty("collectionURI")
    public String getCollectionURI() {
        return collectionURI;
    }

    @JsonProperty("collectionURI")
    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    @JsonProperty("items")
    public List<Story> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Story> items) {
        this.items = items;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.available);
        dest.writeString(this.returned);
        dest.writeString(this.collectionURI);
        dest.writeList(this.items);
    }

    public StoriesResponse() {
    }

    protected StoriesResponse(Parcel in) {
        this.available = in.readString();
        this.returned = in.readString();
        this.collectionURI = in.readString();
        this.items = new ArrayList<Story>();
        in.readList(this.items, Story.class.getClassLoader());
    }

    public static final Parcelable.Creator<StoriesResponse> CREATOR = new Parcelable.Creator<StoriesResponse>() {
        @Override
        public StoriesResponse createFromParcel(Parcel source) {
            return new StoriesResponse(source);
        }

        @Override
        public StoriesResponse[] newArray(int size) {
            return new StoriesResponse[size];
        }
    };

    public List<String> getStoryNames() {
        List<String> storyNames = new ArrayList<>();
        for (Story item : items) {
            storyNames.add(item.getName());
        }
        return storyNames;
    }
}
