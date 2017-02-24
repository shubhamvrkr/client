package com.cardroid.psl.obdcardroid.MockClasses;

import com.cardroid.psl.obdcardroid.Fragments.Dashboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shubham on 24/2/17.
 */

public class CSVFile {

    InputStream inputStream;

    public CSVFile(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public List read() {
        List resultList = new ArrayList<DashboardObj>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine;
            while ((csvLine = reader.readLine()) != null) {

                DashboardObj obj = new DashboardObj();
                String[] row = csvLine.split(",");
                obj.setRpmfield(row[1]);
                obj.setEngineCoolantfield(row[2]);
                obj.setLoadfield(row[3]);
                obj.setIntakeManifoldPressurefield(row[4]);
                obj.setModuleVoltagefield(row[5]);
                obj.setShortfuelTrimfield(row[6]);
                obj.setLongfuelTrimfield(row[7]);
                System.out.println(row);
                resultList.add(row);
            }
        } catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: " + ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: " + e);
            }
        }
        return resultList;
    }
}
