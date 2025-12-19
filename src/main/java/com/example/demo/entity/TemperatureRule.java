@Entity
@Getter
@Setter
public class TemperatureRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double minTemp;
    private Double maxTemp;

    private LocalDateTime effectiveFrom;
    private LocalDateTime effectiveTo;
}
