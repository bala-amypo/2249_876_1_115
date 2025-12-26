@RestController
@RequestMapping("/rules")
public class TemperatureRuleController {

    @PostMapping
    public TemperatureRule create(@RequestBody TemperatureRule rule) {
        return repository.save(rule);
    }

    @GetMapping("/active")
    public List<TemperatureRule> getActive() {
        return repository.findByActiveTrue();
    }
}
