package intruderpayloads;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;

public class IntruderPayloads implements BurpExtension {

    @Override
    public void initialize(MontoyaApi api) {
        api.extension().setName("My Intruder Payloads");
        api.intruder().registerPayloadGeneratorProvider(new MyPayloadGeneratorProvider()); //Missing function
        api.intruder().registerPayloadProcessor(new MyPayloadProcessor(api)); //Missing function
    }
}
