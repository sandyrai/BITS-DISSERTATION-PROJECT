@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Flux<Customer> getAllCustomers() {
        return customerRepository.findAll()
                .filter(customer -> customer.isActive())
                .delayElements(Duration.ofMillis(100));
    }
}
