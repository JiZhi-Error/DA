package com.facebook.device.yearclass;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import java.util.ArrayList;
import java.util.Collections;

public class YearClass {
    public static final int CLASS_2008 = 2008;
    public static final int CLASS_2009 = 2009;
    public static final int CLASS_2010 = 2010;
    public static final int CLASS_2011 = 2011;
    public static final int CLASS_2012 = 2012;
    public static final int CLASS_2013 = 2013;
    public static final int CLASS_2014 = 2014;
    public static final int CLASS_2015 = 2015;
    public static final int CLASS_2016 = 2016;
    public static final int CLASS_UNKNOWN = -1;
    private static final long MB = 1048576;
    private static final int MHZ_IN_KHZ = 1000;
    private static volatile Integer mYearCategory;

    public static int get(Context context) {
        AppMethodBeat.i(133648);
        if (mYearCategory == null) {
            synchronized (YearClass.class) {
                try {
                    if (mYearCategory == null) {
                        mYearCategory = Integer.valueOf(categorizeByYear2016Method(context));
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(133648);
                    throw th;
                }
            }
        }
        int intValue = mYearCategory.intValue();
        AppMethodBeat.o(133648);
        return intValue;
    }

    private static void conditionallyAdd(ArrayList<Integer> arrayList, int i2) {
        AppMethodBeat.i(133649);
        if (i2 != -1) {
            arrayList.add(Integer.valueOf(i2));
        }
        AppMethodBeat.o(133649);
    }

    private static int categorizeByYear2016Method(Context context) {
        AppMethodBeat.i(133650);
        long totalMemory = DeviceInfo.getTotalMemory(context);
        if (totalMemory == -1) {
            int categorizeByYear2014Method = categorizeByYear2014Method(context);
            AppMethodBeat.o(133650);
            return categorizeByYear2014Method;
        } else if (totalMemory <= 805306368) {
            if (DeviceInfo.getNumberOfCPUCores() <= 1) {
                AppMethodBeat.o(133650);
                return 2009;
            }
            AppMethodBeat.o(133650);
            return 2010;
        } else if (totalMemory <= TPAudioFrame.TP_CH_STEREO_RIGHT) {
            if (DeviceInfo.getCPUMaxFreqKHz() < 1300000) {
                AppMethodBeat.o(133650);
                return 2011;
            }
            AppMethodBeat.o(133650);
            return 2012;
        } else if (totalMemory <= TPAudioFrame.TP_CH_LAYOUT_STEREO_DOWNMIX) {
            if (DeviceInfo.getCPUMaxFreqKHz() < 1800000) {
                AppMethodBeat.o(133650);
                return 2012;
            }
            AppMethodBeat.o(133650);
            return 2013;
        } else if (totalMemory <= 2147483648L) {
            AppMethodBeat.o(133650);
            return 2013;
        } else if (totalMemory <= 3221225472L) {
            AppMethodBeat.o(133650);
            return 2014;
        } else if (totalMemory <= 5368709120L) {
            AppMethodBeat.o(133650);
            return 2015;
        } else {
            AppMethodBeat.o(133650);
            return 2016;
        }
    }

    private static int categorizeByYear2014Method(Context context) {
        AppMethodBeat.i(133651);
        ArrayList arrayList = new ArrayList();
        conditionallyAdd(arrayList, getNumCoresYear());
        conditionallyAdd(arrayList, getClockSpeedYear());
        conditionallyAdd(arrayList, getRamYear(context));
        if (arrayList.isEmpty()) {
            AppMethodBeat.o(133651);
            return -1;
        }
        Collections.sort(arrayList);
        if ((arrayList.size() & 1) == 1) {
            int intValue = ((Integer) arrayList.get(arrayList.size() / 2)).intValue();
            AppMethodBeat.o(133651);
            return intValue;
        }
        int size = (arrayList.size() / 2) - 1;
        int intValue2 = ((((Integer) arrayList.get(size + 1)).intValue() - ((Integer) arrayList.get(size)).intValue()) / 2) + ((Integer) arrayList.get(size)).intValue();
        AppMethodBeat.o(133651);
        return intValue2;
    }

    private static int getNumCoresYear() {
        AppMethodBeat.i(133652);
        int numberOfCPUCores = DeviceInfo.getNumberOfCPUCores();
        if (numberOfCPUCores <= 0) {
            AppMethodBeat.o(133652);
            return -1;
        } else if (numberOfCPUCores == 1) {
            AppMethodBeat.o(133652);
            return 2008;
        } else if (numberOfCPUCores <= 3) {
            AppMethodBeat.o(133652);
            return 2011;
        } else {
            AppMethodBeat.o(133652);
            return 2012;
        }
    }

    private static int getClockSpeedYear() {
        AppMethodBeat.i(133653);
        long cPUMaxFreqKHz = (long) DeviceInfo.getCPUMaxFreqKHz();
        if (cPUMaxFreqKHz == -1) {
            AppMethodBeat.o(133653);
            return -1;
        } else if (cPUMaxFreqKHz <= 528000) {
            AppMethodBeat.o(133653);
            return 2008;
        } else if (cPUMaxFreqKHz <= 620000) {
            AppMethodBeat.o(133653);
            return 2009;
        } else if (cPUMaxFreqKHz <= 1020000) {
            AppMethodBeat.o(133653);
            return 2010;
        } else if (cPUMaxFreqKHz <= 1220000) {
            AppMethodBeat.o(133653);
            return 2011;
        } else if (cPUMaxFreqKHz <= 1520000) {
            AppMethodBeat.o(133653);
            return 2012;
        } else if (cPUMaxFreqKHz <= 2020000) {
            AppMethodBeat.o(133653);
            return 2013;
        } else {
            AppMethodBeat.o(133653);
            return 2014;
        }
    }

    private static int getRamYear(Context context) {
        AppMethodBeat.i(133654);
        long totalMemory = DeviceInfo.getTotalMemory(context);
        if (totalMemory <= 0) {
            AppMethodBeat.o(133654);
            return -1;
        } else if (totalMemory <= 201326592) {
            AppMethodBeat.o(133654);
            return 2008;
        } else if (totalMemory <= 304087040) {
            AppMethodBeat.o(133654);
            return 2009;
        } else if (totalMemory <= TPAudioFrame.TP_CH_STEREO_LEFT) {
            AppMethodBeat.o(133654);
            return 2010;
        } else if (totalMemory <= TPAudioFrame.TP_CH_STEREO_RIGHT) {
            AppMethodBeat.o(133654);
            return 2011;
        } else if (totalMemory <= TPAudioFrame.TP_CH_LAYOUT_STEREO_DOWNMIX) {
            AppMethodBeat.o(133654);
            return 2012;
        } else if (totalMemory <= 2147483648L) {
            AppMethodBeat.o(133654);
            return 2013;
        } else {
            AppMethodBeat.o(133654);
            return 2014;
        }
    }
}
