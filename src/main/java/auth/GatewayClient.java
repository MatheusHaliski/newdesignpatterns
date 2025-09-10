package auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GatewayClient {

    private final RestTemplate restTemplate;
    private final String gatewayUrl;

    public GatewayClient(RestTemplate restTemplate,
                         @Value("${api.gateway.url}") String gatewayUrl) {
        this.restTemplate = restTemplate;
        this.gatewayUrl = gatewayUrl;
    }

    public String getOrders() {
        return restTemplate.getForObject(gatewayUrl + "/api/orders", String.class);
    }

    public String getPayments() {
        return restTemplate.getForObject(gatewayUrl + "/api/payments", String.class);
    }

    public String getUsers() {
        return restTemplate.getForObject(gatewayUrl + "/api/users", String.class);
    }
}
