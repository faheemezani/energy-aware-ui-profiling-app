package my.edu.utem.faheemezani.ecommerce;

import android.os.Process;

import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CpuUsageMonitor {

    // Read CPU stats from /proc/[pid]/stat
    public static long[] readCpuTimes() {
        int pid = Process.myPid();
        String path = "/proc/" + pid + "/stat";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String[] stats = reader.readLine().split(" ");

            long utime = Long.parseLong(stats[13]);
            long stime = Long.parseLong(stats[14]);
            long cutime = Long.parseLong(stats[15]);
            long cstime = Long.parseLong(stats[16]);

            return new long[]{utime, stime, cutime, cstime};

        } catch (IOException e) {
            e.printStackTrace();
            return new long[]{-1, -1, -1, -1};
        }
    }

    // Compute usage percent between two snapshots
    public static float getAppCpuUsagePercent(long[] before, long[] after, long intervalMillis) {
        long delta = (after[0] + after[1]) - (before[0] + before[1]);
        long totalTicks = intervalMillis * getClockTicksPerSecond() / 1000;

        return (float) delta / totalTicks * 100f;
    }

    // Get system clock tick rate (usually 100 per second)
    public static int getClockTicksPerSecond() {
        return 100;
    }

    // Utility method to log CPU usage over a sample period
    public static void logCpuUsageOverInterval(long intervalMillis) {
        long[] before = readCpuTimes();
        try {
            Thread.sleep(intervalMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long[] after = readCpuTimes();

        float usage = getAppCpuUsagePercent(before, after, intervalMillis);
        Log.d("CPU_USAGE", "App CPU usage over " + intervalMillis + " ms: " + usage + "%");
    }
}

