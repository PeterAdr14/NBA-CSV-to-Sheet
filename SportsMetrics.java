package org.example;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.util.ArrayList;

public class SportsMetrics {
    /**
     * Initializing the path to the JSON Key, CSV File, Google Sheet ID, target range, and the user entered
     */
    private static final String CREDENTIALS_FILE_PATH = "./Resources/nba-stats-381922-853d6be8f1fe.json";
    private static final String CSV_FILE_PATH = "./Resources/22-23_Stats(Mar27).csv";
    private static final String SHEET_ID = "1swc93fT7O1cwwjfNDlT3BVGRKAaJFF5iX67nHm8xadE";
    static String targetRange = "Sheet1!A1:P";
    private enum valueInputOption {
        USER_ENTERED {
            public String toString() {
                return "USER_ENTERED";
            }
        }
    }
    public static void main(String[] args) throws Exception {
        /**
         * Call necessary functions made
         */
        GoogleCredential cred = Connect.authorize(CREDENTIALS_FILE_PATH);
        Sheets gsheet = Connect.getSheetsService(cred);
        ArrayList list = ReadCSV.GetData(CSV_FILE_PATH);

        ValueRange body = new ValueRange().setValues(list);
        /**
         * Try-catch to ensure connection to the Google Sheet
         */
        try {
            UpdateValuesResponse result =
                    gsheet.spreadsheets().values().update(SHEET_ID, targetRange, body)
                            .setValueInputOption(valueInputOption.USER_ENTERED.toString())
                            .execute();
        }catch(Exception e){
            System.out.println("failed");
            e.printStackTrace();
        }
        System.out.println("Successfully Connected");
    }
}
