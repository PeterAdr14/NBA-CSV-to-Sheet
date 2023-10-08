# NBA-CSV-to-Sheet

This program will take in a CSV file (the one currently used is of NBA players' stats at the end of the 2022/23 season). From there, it transforms the dataset in order to grab and store the information that is actually wanted. From there, it makes an attempt to connect to the Google Sheet:

https://docs.google.com/spreadsheets/d/1swc93fT7O1cwwjfNDlT3BVGRKAaJFF5iX67nHm8xadE/edit#gid=0

This is achieved through a Google API and a JSON key, which can be set up by logging into the Google Cloud Platform, creating a project, creating a service account, and finally creating the JSON key. The path for the key and CSV file will need to be replaced in the code and the target range depending on the data you wish to move over. With a valid JSON key, you should be able to connect to the Google Sheet, which would automatically update the graphs on the Dashboard page on the sheets.
