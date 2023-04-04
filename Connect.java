package org.example;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import java.io.*;
import java.util.Collections;
import java.util.List;

public class Connect {
    /**
     * Initializing the application name, the json factory, and the http transport
     */
    private static final String APPLICATION_NAME = "22/23 NBA Players";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final NetHttpTransport HTTP_TRANSPORT = new NetHttpTransport();

/**
  * Initializing scope for the Google Sheets
 */
    private static final List<String> SCOPES =
            Collections.singletonList(SheetsScopes.SPREADSHEETS);

    public static GoogleCredential authorize(String jsonKeyPath) throws Exception {

        /**
         * Connect with json
         * work around of impersonate user with builder
         */
        InputStream authStream = new FileInputStream(jsonKeyPath);
        GoogleCredential gcFromJson = GoogleCredential.fromStream(authStream, HTTP_TRANSPORT, JSON_FACTORY)
                .createScoped(SCOPES);

        /**
         * Create new Google credentials object
         */
        return new GoogleCredential.Builder()
                .setTransport(gcFromJson.getTransport())
                .setJsonFactory(gcFromJson.getJsonFactory())
                .setServiceAccountId(gcFromJson.getServiceAccountId())
                .setServiceAccountPrivateKey(gcFromJson.getServiceAccountPrivateKey())
                .setServiceAccountScopes(gcFromJson.getServiceAccountScopes())
                .build();
    }
    public static Sheets getSheetsService(GoogleCredential credential) {

        return new Sheets.Builder(
                HTTP_TRANSPORT,
                JSON_FACTORY,
                setTimeout(credential, (3*60000)))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }
    /**
     * Overriding the setTimeout function
     */
    private static HttpRequestInitializer setTimeout(final HttpRequestInitializer initializer, final int timeout) {
        return request -> {
            initializer.initialize(request);
            request.setReadTimeout(timeout);
        };
    }
}