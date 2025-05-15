package intruderpayloads;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;

public class IntruderPayloads implements BurpExtension {

    @Override
    public void initialize(MontoyaApi api) {
        api.extension().setName("Intruder Payloads");
        api.intruder().registerPayloadGeneratorProvider(new InjectionsGeneratorProvider("Payload Type 1"));
        api.intruder().registerPayloadGeneratorProvider(new XSSGeneratorProvider("Payload Type 2"));
        api.intruder().registerPayloadGeneratorProvider(new PathTraversalGeneratorProvider("Payload Type 3"));
        api.intruder().registerPayloadGeneratorProvider(new SSRFGeneratorProvider("Payload Type 4"));
        api.intruder().registerPayloadGeneratorProvider(new OpenRedirectGeneratorProvider("Payload Type 5"));
        api.intruder().registerPayloadGeneratorProvider(new CookiesGeneratorProvider("Payload Type 6"));
        api.intruder().registerPayloadGeneratorProvider(new NoSQLGeneratorProvider("Payload Type 7"));
    }
}
