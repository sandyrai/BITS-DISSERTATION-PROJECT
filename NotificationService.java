@Service
public class NotificationService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public Mono<Void> sendStockAlert(String message) {
        return Mono.fromRunnable(() -> kafkaTemplate.send("stock-alerts", message))
                   .then();
    }
}
