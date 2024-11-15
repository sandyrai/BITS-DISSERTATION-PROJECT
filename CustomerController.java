@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public Flux<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}

