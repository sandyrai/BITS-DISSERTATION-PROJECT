@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/check/{itemId}")
    public Mono<ResponseEntity<Inventory>> getInventory(@PathVariable String itemId) {
        return inventoryService.getStock(itemId)
                .map(stock -> ResponseEntity.ok(stock))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}

