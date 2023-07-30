package com.example.practice.webCalculator;

import com.example.practice.calculator.Calculator;
import com.example.practice.calculator.calculate.PositiveNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

@Slf4j
@RequiredArgsConstructor
public class ClientRequestHandler implements Runnable {

    private final Socket clientSocket;

    @Override
    public void run() {
        log.info("[ClientRequestHandler] new client {} started.", Thread.currentThread().getName());
        try (
                InputStream in = clientSocket.getInputStream();
                OutputStream out = clientSocket.getOutputStream()
        ) {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(in, StandardCharsets.UTF_8)
            );
            DataOutputStream dos = new DataOutputStream(out);

            HttpRequest httpRequest = new HttpRequest(br);

            if (httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
                QueryStrings queryStrings = httpRequest.getQueryString();

                int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
                String operator = queryStrings.getValue("operator");
                int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));

                int result = Calculator.calculate(
                        new PositiveNumber(operand1), operator, new PositiveNumber(operand2)
                );
                byte[] body = String.valueOf(result).getBytes();

                HttpResponse response = new HttpResponse(dos);
                response.response200Header("application/json", body.length);
                response.responseBody(body);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

}
