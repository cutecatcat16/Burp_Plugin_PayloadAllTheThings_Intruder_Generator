package intruderpayloads;

import burp.api.montoya.intruder.GeneratedPayload;
import burp.api.montoya.intruder.IntruderInsertionPoint;
import burp.api.montoya.intruder.PayloadGenerator;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Total payload number == 2366 per position.
public class XSSPayloadGenerator implements PayloadGenerator {

    private final List<String> payloads;
    private int payloadIndex = 0;

    public XSSPayloadGenerator() throws IOException {
        payloads = new ArrayList<>();

        // Load the index file that lists all payload files
        InputStream indexStream = getClass().getClassLoader().getResourceAsStream("XSS-index.txt");
        if (indexStream == null) {
            throw new FileNotFoundException("XSS-index.txt not found in resources.");
        }

        List<String> fileList = new BufferedReader(new InputStreamReader(indexStream, Charset.defaultCharset()))
                .lines()
                .collect(Collectors.toList());

        for (String path : fileList) {
            InputStream fileStream = getClass().getClassLoader().getResourceAsStream(path);
            if (fileStream == null) {
                throw new FileNotFoundException("File not found: " + path);
            }

            List<String> lines = new BufferedReader(new InputStreamReader(fileStream, Charset.defaultCharset()))
                    .lines()
                    .collect(Collectors.toList());

            payloads.addAll(lines);
        }

        System.out.println("Loaded " + payloads.size() + " payloads from " + fileList.size() + " files.");
    }

    @Override
    public GeneratedPayload generatePayloadFor(IntruderInsertionPoint insertionPoint) {
        if (payloadIndex >= payloads.size()) {
            return GeneratedPayload.end();
        }

        return GeneratedPayload.payload(payloads.get(payloadIndex++));
    }
}
