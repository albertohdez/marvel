
package com.alberto.marvel.common.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.alberto.marvel.common.model.Comic;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComicsResponse implements Parcelable {

    @JsonProperty("available")
    private String available;
    @JsonProperty("returned")
    private String returned;
    @JsonProperty("collectionURI")
    private String collectionURI;
    @JsonProperty("items")
    private List<Comic> items = null;

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
    public List<Comic> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Comic> items) {
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

    public ComicsResponse() {
    }

    protected ComicsResponse(Parcel in) {
        this.available = in.readString();
        this.returned = in.readString();
        this.collectionURI = in.readString();
        this.items = new ArrayList<Comic>();
        in.readList(this.items, Comic.class.getClassLoader());
    }

    public static final Parcelable.Creator<ComicsResponse> CREATOR = new Parcelable.Creator<ComicsResponse>() {
        @Override
        public ComicsResponse createFromParcel(Parcel source) {
            return new ComicsResponse(source);
        }

        @Override
        public ComicsResponse[] newArray(int size) {
            return new ComicsResponse[size];
        }
    };
}
