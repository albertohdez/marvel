
package com.alberto.marvel.common.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.alberto.marvel.common.model.Serie;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeriesResponse implements Parcelable {

    @JsonProperty("available")
    private String available;
    @JsonProperty("returned")
    private String returned;
    @JsonProperty("collectionURI")
    private String collectionURI;
    @JsonProperty("items")
    private List<Serie> items = null;

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
    public List<Serie> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Serie> items) {
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

    public SeriesResponse() {
    }

    protected SeriesResponse(Parcel in) {
        this.available = in.readString();
        this.returned = in.readString();
        this.collectionURI = in.readString();
        this.items = new ArrayList<Serie>();
        in.readList(this.items, Serie.class.getClassLoader());
    }

    public static final Parcelable.Creator<SeriesResponse> CREATOR = new Parcelable.Creator<SeriesResponse>() {
        @Override
        public SeriesResponse createFromParcel(Parcel source) {
            return new SeriesResponse(source);
        }

        @Override
        public SeriesResponse[] newArray(int size) {
            return new SeriesResponse[size];
        }
    };

    public List<String> getSerieNames() {
        List<String> serieNames = new ArrayList<>();
        for (Serie item : items) {
            serieNames.add(item.getName());
        }
        return serieNames;
    }
}
