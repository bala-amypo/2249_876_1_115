@RestController
@RequestMapping("/alerts")
public class AlertRecordController {

    @PostMapping
    public AlertRecord create(@RequestBody AlertRecord alert) {
        return repository.save(alert);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<AlertRecord> getByShipment(@PathVariable Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }
}
