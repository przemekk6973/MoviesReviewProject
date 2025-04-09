package dev.przemekk6973.movies.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;
import java.util.Objects;

@Document(collection = "movies")
public class MovieModel {

    @Setter
    @Getter
    @Id
    private ObjectId id;
    @Setter
    @Getter
    private String imdbId;
    @Setter
    @Getter
    private String title;
    @Setter
    @Getter
    private String releaseDate;
    @Setter
    @Getter
    private String trailerLink;
    @Setter
    @Getter
    private String poster;
    @Setter
    @Getter
    private List<String> backdrops;
    @Setter
    @Getter
    private List<String> genres;

    @DocumentReference
    private List<ReviewModel> reviewModels;

    public MovieModel() {
        // Konstruktor domyślny
    }

    public MovieModel(ObjectId id, String imdbId, String title, String releaseDate, String trailerLink, String poster,
                      List<String> backdrops, List<String> genres, List<ReviewModel> reviewModels) {
        this.id = id;
        this.imdbId = imdbId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.trailerLink = trailerLink;
        this.poster = poster;
        this.backdrops = backdrops;
        this.genres = genres;
        this.reviewModels = reviewModels;
    }

    public MovieModel(String imdbId, String title, String releaseDate, String trailerLink, String poster,
                      List<String> backdrops, List<String> genres) {
        this(null, imdbId, title, releaseDate, trailerLink, poster, backdrops, genres, null);
    }

    // Gettery i settery

    public List<ReviewModel> getReviews() {
        return reviewModels;
    }

    public void setReviews(List<ReviewModel> reviewModels) {
        this.reviewModels = reviewModels;
    }

    // equals, hashCode i toString – oparte głównie na imdbId

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieModel movieModel = (MovieModel) o;
        return Objects.equals(imdbId, movieModel.imdbId);
    }

    @Override
    public int hashCode() {
        return imdbId != null ? imdbId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", imdbId='" + imdbId + '\'' +
                ", title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", trailerLink='" + trailerLink + '\'' +
                ", poster='" + poster + '\'' +
                ", backdrops=" + backdrops +
                ", genres=" + genres +
                ", reviews=" + reviewModels +
                '}';
    }
}
