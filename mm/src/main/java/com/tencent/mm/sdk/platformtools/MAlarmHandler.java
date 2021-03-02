package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

public class MAlarmHandler {
    private static final int MAX_TIMERID = 8192;
    public static final long NEXT_FIRE_INTERVAL = Long.MAX_VALUE;
    private static final String TAG = "MicroMsg.MAlarmHandler";
    private static IBumper bumper;
    private static boolean initilized = false;
    private static Map<Integer, MAlarmHandler> maps = new HashMap();
    private static int timerID;
    private static boolean withNewStart;
    private final CallBack callback;
    private long interval = 0;
    private final boolean loop;
    private final int myTimerID;
    private long ts = 0;

    public interface CallBack {
        boolean onTimerExpired();
    }

    public interface IBumper {
        void cancel();

        void prepare();
    }

    static {
        AppMethodBeat.i(157607);
        AppMethodBeat.o(157607);
    }

    public static void initAlarmBumper(IBumper iBumper) {
        initilized = true;
        bumper = iBumper;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(157601);
        stopTimer();
        super.finalize();
        AppMethodBeat.o(157601);
    }

    public MAlarmHandler(CallBack callBack, boolean z) {
        AppMethodBeat.i(230326);
        Assert.assertTrue("bumper not initialized", initilized);
        this.callback = callBack;
        this.loop = z;
        this.myTimerID = incTimerID();
        AppMethodBeat.o(230326);
    }

    private static int incTimerID() {
        if (timerID >= 8192) {
            timerID = 0;
        }
        int i2 = timerID + 1;
        timerID = i2;
        return i2;
    }

    public static long fire() {
        AppMethodBeat.i(157603);
        withNewStart = false;
        LinkedList linkedList = new LinkedList();
        HashSet<Integer> hashSet = new HashSet();
        hashSet.addAll(maps.keySet());
        long j2 = Long.MAX_VALUE;
        for (Integer num : hashSet) {
            MAlarmHandler mAlarmHandler = maps.get(num);
            if (mAlarmHandler != null) {
                long ticksToNow = Util.ticksToNow(mAlarmHandler.ts);
                if (ticksToNow < 0) {
                    ticksToNow = 0;
                }
                if (ticksToNow > mAlarmHandler.interval) {
                    if (!mAlarmHandler.callback.onTimerExpired() || !mAlarmHandler.loop) {
                        linkedList.add(num);
                    } else {
                        j2 = mAlarmHandler.interval;
                    }
                    mAlarmHandler.ts = Util.currentTicks();
                } else if (mAlarmHandler.interval - ticksToNow < j2) {
                    j2 = mAlarmHandler.interval - ticksToNow;
                }
            }
            j2 = j2;
        }
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            maps.remove(linkedList.get(i2));
        }
        if (!withNewStart && j2 == NEXT_FIRE_INTERVAL && bumper != null) {
            bumper.cancel();
            Log.v(TAG, "cancel bumper for no more handler");
        }
        AppMethodBeat.o(157603);
        return j2;
    }

    public void startTimer(long j2) {
        AppMethodBeat.i(230327);
        withNewStart = true;
        this.interval = j2;
        this.ts = Util.currentTicks();
        boolean needPrepare = needPrepare(this.interval);
        stopTimer();
        maps.put(Integer.valueOf(this.myTimerID), this);
        if (bumper != null && needPrepare) {
            Log.v(TAG, "prepare bumper");
            bumper.prepare();
        }
        AppMethodBeat.o(230327);
    }

    public void stopTimer() {
        AppMethodBeat.i(157605);
        maps.remove(Integer.valueOf(this.myTimerID));
        AppMethodBeat.o(157605);
    }

    public boolean stopped() {
        AppMethodBeat.i(230328);
        if (!maps.containsKey(Integer.valueOf(this.myTimerID))) {
            AppMethodBeat.o(230328);
            return true;
        }
        AppMethodBeat.o(230328);
        return false;
    }

    private static boolean needPrepare(long j2) {
        long j3;
        AppMethodBeat.i(157606);
        Log.d(TAG, "check need prepare: check=".concat(String.valueOf(j2)));
        long j4 = NEXT_FIRE_INTERVAL;
        Iterator<Map.Entry<Integer, MAlarmHandler>> it = maps.entrySet().iterator();
        while (true) {
            j3 = j4;
            if (!it.hasNext()) {
                break;
            }
            MAlarmHandler value = it.next().getValue();
            if (value != null) {
                long ticksToNow = Util.ticksToNow(value.ts);
                if (ticksToNow < 0) {
                    ticksToNow = 0;
                }
                if (ticksToNow > value.interval) {
                    j4 = value.interval;
                } else if (value.interval - ticksToNow < j3) {
                    j3 = value.interval - ticksToNow;
                }
            }
            j4 = j3;
        }
        if (j3 > j2) {
            AppMethodBeat.o(157606);
            return true;
        }
        AppMethodBeat.o(157606);
        return false;
    }
}
