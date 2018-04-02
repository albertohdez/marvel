
package com.alberto.marvel.common.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultResponse implements Parcelable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("modified")
    private String modified;
    @JsonProperty("resourceURI")
    private String resourceURI;
    @JsonProperty("urls")
    private List<UrlResponse> urls = null;
    @JsonProperty("thumbnail")
    private ThumbnailResponse thumbnail;
    @JsonProperty("comics")
    private ComicsResponse comics;
    @JsonProperty("stories")
    private StoriesResponse stories;
    @JsonProperty("events")
    private EventsResponse events;
    @JsonProperty("series")
    private SeriesResponse series;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("modified")
    public String getModified() {
        return modified;
    }

    @JsonProperty("modified")
    public void setModified(String modified) {
        this.modified = modified;
    }

    @JsonProperty("resourceURI")
    public String getResourceURI() {
        return resourceURI;
    }

    @JsonProperty("resourceURI")
    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    @JsonProperty("urls")
    public List<UrlResponse> getUrls() {
        return urls;
    }

    @JsonProperty("urls")
    public void setUrls(List<UrlResponse> urls) {
        this.urls = urls;
    }

    @JsonProperty("thumbnail")
    public ThumbnailResponse getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(ThumbnailResponse thumbnail) {
        this.thumbnail = thumbnail;
    }

    @JsonProperty("comics")
    public ComicsResponse getComics() {
        return comics;
    }

    @JsonProperty("comics")
    public void setComics(ComicsResponse comics) {
        this.comics = comics;
    }

    @JsonProperty("stories")
    public StoriesResponse getStories() {
        return stories;
    }

    @JsonProperty("stories")
    public void setStories(StoriesResponse stories) {
        this.stories = stories;
    }

    @JsonProperty("events")
    public EventsResponse getEvents() {
        return events;
    }

    @JsonProperty("events")
    public void setEvents(EventsResponse events) {
        this.events = events;
    }

    @JsonProperty("series")
    public SeriesResponse getSeries() {
        return series;
    }

    @JsonProperty("series")
    public void setSeries(SeriesResponse series) {
        this.series = series;
    }

    public String getImageUrl() {
        return thumbnail.buildCompleteImagePath();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.modified);
        dest.writeString(this.resourceURI);
        dest.writeList(this.urls);
        dest.writeParcelable(this.thumbnail, flags);
        dest.writeParcelable(this.comics, flags);
        dest.writeParcelable(this.stories, flags);
        dest.writeParcelable(this.events, flags);
        dest.writeParcelable(this.series, flags);
    }

    public ResultResponse() {
    }

    protected ResultResponse(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.description = in.readString();
        this.modified = in.readString();
        this.resourceURI = in.readString();
        this.urls = new ArrayList<UrlResponse>();
        in.readList(this.urls, UrlResponse.class.getClassLoader());
        this.thumbnail = in.readParcelable(ThumbnailResponse.class.getClassLoader());
        this.comics = in.readParcelable(ComicsResponse.class.getClassLoader());
        this.stories = in.readParcelable(StoriesResponse.class.getClassLoader());
        this.events = in.readParcelable(EventsResponse.class.getClassLoader());
        this.series = in.readParcelable(SeriesResponse.class.getClassLoader());
    }

    public static final Parcelable.Creator<ResultResponse> CREATOR = new Parcelable.Creator<ResultResponse>() {
        @Override
        public ResultResponse createFromParcel(Parcel source) {
            return new ResultResponse(source);
        }

        @Override
        public ResultResponse[] newArray(int size) {
            return new ResultResponse[size];
        }
    };
}
