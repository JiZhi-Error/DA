package com.tencent.mm.booter;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.os.Handler;
import android.os.Looper;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.af;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public class KeepAliveService extends JobService {
    public static long gls;

    static {
        AppMethodBeat.i(131881);
        if (d.oD(23)) {
            gls = 590000;
            AppMethodBeat.o(131881);
            return;
        }
        gls = 50000;
        AppMethodBeat.o(131881);
    }

    public boolean onStartJob(final JobParameters jobParameters) {
        AppMethodBeat.i(131878);
        Log.i("MicroMsg.KeepAliveService", "onStartJob()");
        if (af.bkl() == null) {
            Log.i("MicroMsg.KeepAliveService", "onStarJob() MMPushCore.getAutoAuth() == null");
            b.c(MMApplicationContext.getContext(), "jobservice", true);
        }
        new Handler().postDelayed(new Runnable() {
            /* class com.tencent.mm.booter.KeepAliveService.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(131876);
                Log.i("MicroMsg.KeepAliveService", "onStartJob() delay");
                KeepAliveService.akB();
                try {
                    KeepAliveService.this.jobFinished(jobParameters, false);
                    AppMethodBeat.o(131876);
                } catch (Exception e2) {
                    Log.e("MicroMsg.KeepAliveService", "onStartJob() jobFinished() Exception=%s", e2.getMessage());
                    AppMethodBeat.o(131876);
                }
            }
        }, gls);
        Log.i("MicroMsg.KeepAliveService", "onReceive() delay publish PushKeepAliveEvent");
        h.RTc.n(new Runnable() {
            /* class com.tencent.mm.booter.KeepAliveService.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(131877);
                EventCenter.instance.asyncPublish(new qb(), Looper.getMainLooper());
                Log.i("MicroMsg.KeepAliveService", "onReceive() publish PushKeepAliveEvent");
                AppMethodBeat.o(131877);
            }
        }, Util.MILLSECONDS_OF_MINUTE);
        AppMethodBeat.o(131878);
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        AppMethodBeat.i(131879);
        Log.i("MicroMsg.KeepAliveService", "onStopJob()");
        AppMethodBeat.o(131879);
        return false;
    }

    public static boolean akB() {
        AppMethodBeat.i(131880);
        if (a.apK().getBoolean("keepaliveserviceswitch", false)) {
            Log.i("MicroMsg.KeepAliveService", "scheduleCoreScheduleJob(), time = %d", Long.valueOf(gls));
            try {
                JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(MMApplicationContext.getContext(), KeepAliveService.class));
                builder.setMinimumLatency(0);
                builder.setOverrideDeadline(10);
                builder.setRequiredNetworkType(1);
                builder.setRequiresDeviceIdle(false);
                builder.setRequiresCharging(false);
                JobScheduler jobScheduler = (JobScheduler) MMApplicationContext.getContext().getSystemService("jobscheduler");
                if (jobScheduler == null) {
                    Exception exc = new Exception("Can not get JOB_SCHEDULER_SERVICE");
                    AppMethodBeat.o(131880);
                    throw exc;
                }
                int schedule = jobScheduler.schedule(builder.build());
                if (schedule != 1) {
                    Exception exc2 = new Exception("scheduleCoreScheduleJob fail, result = ".concat(String.valueOf(schedule)));
                    AppMethodBeat.o(131880);
                    throw exc2;
                }
                AppMethodBeat.o(131880);
                return true;
            } catch (Exception e2) {
                Log.e("MicroMsg.KeepAliveService", "scheduleKeepAliveJob() Exception:%s" + e2.getMessage());
            }
        } else {
            AppMethodBeat.o(131880);
            return false;
        }
    }
}
