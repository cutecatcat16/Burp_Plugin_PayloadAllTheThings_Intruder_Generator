package intruderpayloads;

import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;

public class IntruderPayloads implements BurpExtension {

    @Override
    public void initialize(MontoyaApi api) {
        api.extension().setName("PayloadAllTheThings");
        api.intruder().registerPayloadGeneratorProvider(new MyPayloadGeneratorProvider());
        //api.intruder().registerPayloadProcessor(new MyPayloadProcessor(api));
    }
}
