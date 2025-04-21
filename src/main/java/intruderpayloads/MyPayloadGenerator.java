package intruderpayloads;

import burp.api.montoya.intruder.GeneratedPayload;
import burp.api.montoya.intruder.IntruderInsertionPoint;
import burp.api.montoya.intruder.PayloadGenerator;

import java.util.List;

public class MyPayloadGenerator implements PayloadGenerator {

    private static final List<String> PAYLOADS = List.of(
            "|", "test1", "test2"
    ); //Add later
    private int payloadIndex;

    @Override
    public GeneratedPayload generatePayloadFor(IntruderInsertionPoint intruderInsertionPoint) {

        payloadIndex++;

        if (payloadIndex > PAYLOADS.size())
        {
            return GeneratedPayload.end();
        }

        String payload = PAYLOADS.get(payloadIndex);

        return GeneratedPayload.payload(payload);
    }

}
