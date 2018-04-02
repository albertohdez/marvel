
package com.alberto.marvel.common.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.alberto.marvel.common.model.Event;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EventsResponse implements Parcelable {

    @JsonProperty("available")
    private String available;
    @JsonProperty("returned")
    private String returned;
    @JsonProperty("collectionURI")
    private String collectionURI;
    @JsonProperty("items")
    private List<Event> items = null;

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
    public List<Event> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Event> items) {
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

    public EventsResponse() {
    }

    protected EventsResponse(Parcel in) {
        this.available = in.readString();
        this.returned = in.readString();
        this.collectionURI = in.readString();
        this.items = new ArrayList<Event>();
        in.readList(this.items, Event.class.getClassLoader());
    }

    public static final Parcelable.Creator<EventsResponse> CREATOR = new Parcelable.Creator<EventsResponse>() {
        @Override
        public EventsResponse createFromParcel(Parcel source) {
            return new EventsResponse(source);
        }

        @Override
        public EventsResponse[] newArray(int size) {
            return new EventsResponse[size];
        }
    };
}
