@RestController
@RequestMapping("/logs")
public class TemperatureLogController {

    @PostMapping
    public TemperatureLog create(@RequestBody TemperatureLog log) {
        return repository.save(log);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<TemperatureLog> getByShipment(@PathVariable Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }
}
