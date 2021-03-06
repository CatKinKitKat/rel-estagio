/**
 * JSON Model for the Url Update
 */
@Data
@JsonPropertyOrder({
    "url"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonSerialize
@JsonDeserialize
@AllArgsConstructor
@NoArgsConstructor
public class UrlModel {

  /**
   * The Emails.
   */
  @JsonProperty("url")
  private String url;

  /**
   * Run validation checks..
   *
   * @return the boolean
   */
  @JsonIgnore
  public Boolean isValid() {
    return UrlValidator.getInstance().isValid(this.url);
  }
}