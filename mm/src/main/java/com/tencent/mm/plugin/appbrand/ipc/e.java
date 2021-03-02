package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class e {
    private static final HashMap<String, MMToClientEvent> lwY = new HashMap<>();

    static {
        AppMethodBeat.i(134857);
        AppMethodBeat.o(134857);
    }

    public static void a(MMToClientEvent mMToClientEvent) {
        AppMethodBeat.i(134852);
        Log.i("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId:%s, MMToClientEvent.hash:%d", mMToClientEvent.appId, Integer.valueOf(mMToClientEvent.hashCode()));
        if (mMToClientEvent.appId == null) {
            Log.e("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId is null!!!");
            AppMethodBeat.o(134852);
            return;
        }
        synchronized (lwY) {
            try {
                if (lwY.get(mMToClientEvent.appId) == null) {
                    lwY.put(mMToClientEvent.appId, mMToClientEvent);
                } else {
                    Log.d("MicroMsg.MMToClientEventCenter", "The CommonConfig is already exist!~ so replace it");
                    lwY.remove(mMToClientEvent.appId);
                    lwY.put(mMToClientEvent.appId, mMToClientEvent);
                }
            } finally {
                AppMethodBeat.o(134852);
            }
        }
    }

    public static void b(MMToClientEvent mMToClientEvent) {
        AppMethodBeat.i(134853);
        Log.i("MicroMsg.MMToClientEventCenter", "unregister MMToClientEvent.appId:%s", mMToClientEvent.appId);
        synchronized (lwY) {
            try {
                lwY.remove(mMToClientEvent.appId);
            } finally {
                AppMethodBeat.o(134853);
            }
        }
    }

    public static void v(String str, int i2, String str2) {
        MMToClientEvent mMToClientEvent;
        AppMethodBeat.i(134854);
        Log.i("MicroMsg.MMToClientEventCenter", "notify appId:%s, type:%d, config:%s", str, Integer.valueOf(i2), str2);
        synchronized (lwY) {
            try {
                mMToClientEvent = lwY.get(str);
            } finally {
                AppMethodBeat.o(134854);
            }
        }
        if (mMToClientEvent != null) {
            synchronized (mMToClientEvent) {
                try {
                    mMToClientEvent.lwP = 3;
                    mMToClientEvent.appId = str;
                    mMToClientEvent.type = i2;
                    mMToClientEvent.config = str2;
                    mMToClientEvent.bDU();
                } finally {
                    AppMethodBeat.o(134854);
                }
            }
            return;
        }
        Log.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
        AppMethodBeat.o(134854);
    }

    public static void bI(String str, int i2) {
        MMToClientEvent mMToClientEvent;
        AppMethodBeat.i(134855);
        Log.i("MicroMsg.MMToClientEventCenter", "notify unread:%d", Integer.valueOf(i2));
        synchronized (lwY) {
            try {
                mMToClientEvent = lwY.get(str);
            } finally {
                AppMethodBeat.o(134855);
            }
        }
        if (mMToClientEvent != null) {
            synchronized (mMToClientEvent) {
                try {
                    mMToClientEvent.lwP = 4;
                    mMToClientEvent.dCm = i2;
                    mMToClientEvent.bDU();
                } finally {
                    AppMethodBeat.o(134855);
                }
            }
            return;
        }
        Log.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
        AppMethodBeat.o(134855);
    }

    public static <T extends Parcelable> void b(String str, T t) {
        MMToClientEvent mMToClientEvent;
        AppMethodBeat.i(134856);
        synchronized (lwY) {
            try {
                mMToClientEvent = lwY.get(str);
            } finally {
                AppMethodBeat.o(134856);
            }
        }
        if (mMToClientEvent == null) {
            Log.e("MicroMsg.MMToClientEventCenter", "notify failed, appId[%s] data[%s]", str, t);
            AppMethodBeat.o(134856);
        } else if (mMToClientEvent == null || t == null || t == null) {
            AppMethodBeat.o(134856);
        } else {
            synchronized (mMToClientEvent) {
                try {
                    mMToClientEvent.lwP = 5;
                    mMToClientEvent.lwQ = t.getClass().getName();
                    mMToClientEvent.lwR = t;
                    mMToClientEvent.bDU();
                } finally {
                    AppMethodBeat.o(134856);
                }
            }
        }
    }
}
