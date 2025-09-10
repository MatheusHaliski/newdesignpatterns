package auth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final GatewayClient gatewayClient;

    public AuthController(GatewayClient gatewayClient) {
        this.gatewayClient = gatewayClient;
    }

    @GetMapping("/test-orders")
    public String testOrders() {
        return gatewayClient.getOrders();
    }

    @GetMapping("/test-payments")
    public String testPayments() {
        return gatewayClient.getPayments();
    }

    @GetMapping("/test-users")
    public String testUsers() {
        return gatewayClient.getUsers();
    }
}
