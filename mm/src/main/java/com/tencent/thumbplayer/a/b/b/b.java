package com.tencent.thumbplayer.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.a.a.b.c;
import com.tencent.thumbplayer.a.b.b.a;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPErrorCode;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.TPPropertyID;
import com.tencent.thumbplayer.api.connection.TPPlayerConnectionConstant;
import com.tencent.thumbplayer.utils.g;
import java.lang.reflect.Field;

public final class b {
    @TPCommonEnum.NativeSeekMode
    public static int ara(@TPCommonEnum.TPSeekMode int i2) {
        a.h hVar;
        AppMethodBeat.i(188995);
        try {
            Class<?> cls = Class.forName(ITPPlayer.class.getName());
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.getType().toString().equals("int")) {
                    field.setAccessible(true);
                    if (i2 == field.getInt(cls) && (hVar = (a.h) field.getAnnotation(a.h.class)) != null) {
                        int value = hVar.value();
                        AppMethodBeat.o(188995);
                        return value;
                    }
                }
            }
        } catch (ClassNotFoundException e2) {
            g.e("TPNativeKeyMapUtil", e2);
        } catch (IllegalAccessException e3) {
            g.e("TPNativeKeyMapUtil", e3);
        }
        g.w("TPNativeKeyMapUtil", "convertToNativeSeekMode, seek mode is invalid(" + i2 + "), return default mode instead");
        AppMethodBeat.o(188995);
        return 2;
    }

    @TPCommonEnum.NativeSwitchDefMode
    public static int arb(@TPCommonEnum.TPSwitchDefMode int i2) {
        a.i iVar;
        AppMethodBeat.i(188996);
        try {
            Class<?> cls = Class.forName(ITPPlayer.class.getName());
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.getType().toString().equals("int")) {
                    field.setAccessible(true);
                    if (i2 == field.getInt(cls) && (iVar = (a.i) field.getAnnotation(a.i.class)) != null) {
                        int value = iVar.value();
                        AppMethodBeat.o(188996);
                        return value;
                    }
                }
            }
        } catch (ClassNotFoundException e2) {
            g.e("TPNativeKeyMapUtil", e2);
        } catch (IllegalAccessException e3) {
            g.e("TPNativeKeyMapUtil", e3);
        }
        g.w("TPNativeKeyMapUtil", "convertToNativeSwitchDefMode, player switch definition mode is invalid(" + i2 + "), return default mode instead");
        AppMethodBeat.o(188996);
        return 2;
    }

    @TPCommonEnum.TPErrorType
    public static int arc(@TPCommonEnum.NativeErrorType int i2) {
        AppMethodBeat.i(188997);
        try {
            Class<?> cls = Class.forName(TPErrorCode.class.getName());
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.getType().toString().equals("int")) {
                    field.setAccessible(true);
                    a.c cVar = (a.c) field.getAnnotation(a.c.class);
                    if (cVar != null && i2 == cVar.value()) {
                        int i3 = field.getInt(cls);
                        AppMethodBeat.o(188997);
                        return i3;
                    }
                }
            }
        } catch (ClassNotFoundException e2) {
            g.e("TPNativeKeyMapUtil", e2);
        } catch (IllegalAccessException e3) {
            g.e("TPNativeKeyMapUtil", e3);
        }
        g.w("TPNativeKeyMapUtil", "convertToTPErrorType, nativeErrorType: " + i2 + " not recognition, return 1001");
        AppMethodBeat.o(188997);
        return 1001;
    }

    @TPCommonEnum.TPMsgInfo
    public static int ard(@TPCommonEnum.NativeMsgInfo int i2) {
        AppMethodBeat.i(188998);
        try {
            Class<?> cls = Class.forName(TPPlayerMsg.class.getName());
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.getType().toString().equals("int")) {
                    field.setAccessible(true);
                    a.e eVar = (a.e) field.getAnnotation(a.e.class);
                    if (eVar != null && i2 == eVar.value()) {
                        int i3 = field.getInt(cls);
                        AppMethodBeat.o(188998);
                        return i3;
                    }
                }
            }
        } catch (ClassNotFoundException e2) {
            g.e("TPNativeKeyMapUtil", e2);
        } catch (IllegalAccessException e3) {
            g.e("TPNativeKeyMapUtil", e3);
        }
        g.w("TPNativeKeyMapUtil", "convertToTPMsgInfo, nativeMsgInfo: " + i2 + " not recognition, return TP_PLAYER_INFO_LONG0_UNKNOW");
        AppMethodBeat.o(188998);
        return -1;
    }

    public static c.a are(@TPCommonEnum.TPOptionalId int i2) {
        a.d dVar;
        AppMethodBeat.i(188999);
        try {
            Class<?> cls = Class.forName(TPOptionalID.class.getName());
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.getType().toString().equals("int")) {
                    field.setAccessible(true);
                    if (i2 == field.getInt(cls) && (dVar = (a.d) field.getAnnotation(a.d.class)) != null) {
                        c.a aVar = new c.a(dVar.type(), dVar.value());
                        AppMethodBeat.o(188999);
                        return aVar;
                    }
                }
            }
        } catch (ClassNotFoundException e2) {
            g.e("TPNativeKeyMapUtil", e2);
        } catch (IllegalAccessException e3) {
            g.e("TPNativeKeyMapUtil", e3);
        }
        g.w("TPNativeKeyMapUtil", "convertToNativeInitConfig, tpInitConfig: " + i2 + " not recognition, return null");
        AppMethodBeat.o(188999);
        return null;
    }

    public static c.a arf(@TPCommonEnum.TPOptionalId int i2) {
        AppMethodBeat.i(189000);
        c.a arg = arg(i2);
        if (arg == null) {
            c.a arh = arh(i2);
            AppMethodBeat.o(189000);
            return arh;
        }
        AppMethodBeat.o(189000);
        return arg;
    }

    private static c.a arg(@TPCommonEnum.TPOptionalId int i2) {
        AppMethodBeat.i(189001);
        try {
            c.a g2 = g(i2, Class.forName(TPOptionalID.class.getName()));
            AppMethodBeat.o(189001);
            return g2;
        } catch (ClassNotFoundException e2) {
            g.e("TPNativeKeyMapUtil", e2);
            AppMethodBeat.o(189001);
            return null;
        }
    }

    private static c.a arh(@TPCommonEnum.TPOptionalId int i2) {
        AppMethodBeat.i(189002);
        try {
            c.a g2 = g(i2, Class.forName(com.tencent.thumbplayer.g.a.class.getName()));
            AppMethodBeat.o(189002);
            return g2;
        } catch (ClassNotFoundException e2) {
            g.e("TPNativeKeyMapUtil", e2);
            AppMethodBeat.o(189002);
            return null;
        }
    }

    private static c.a g(@TPCommonEnum.TPOptionalId int i2, Class cls) {
        a.f fVar;
        AppMethodBeat.i(189003);
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.getType().toString().equals("int")) {
                    field.setAccessible(true);
                    if (i2 == field.getInt(cls) && (fVar = (a.f) field.getAnnotation(a.f.class)) != null) {
                        c.a aVar = new c.a(fVar.type(), fVar.value());
                        AppMethodBeat.o(189003);
                        return aVar;
                    }
                }
            }
        } catch (IllegalAccessException e2) {
            g.e("TPNativeKeyMapUtil", e2);
        }
        g.w("TPNativeKeyMapUtil", "convertToNativeOptionalIdInternal, tpOptionalId: " + i2 + " not recognition, return null");
        AppMethodBeat.o(189003);
        return null;
    }

    public static int ari(int i2) {
        a.g gVar;
        AppMethodBeat.i(189004);
        try {
            Class<?> cls = Class.forName(TPPropertyID.class.getName());
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.getType().toString().equals("int")) {
                    field.setAccessible(true);
                    if (i2 == field.getInt(cls) && (gVar = (a.g) field.getAnnotation(a.g.class)) != null) {
                        int value = gVar.value();
                        AppMethodBeat.o(189004);
                        return value;
                    }
                }
            }
        } catch (ClassNotFoundException e2) {
            g.e("TPNativeKeyMapUtil", e2);
        } catch (IllegalAccessException e3) {
            g.e("TPNativeKeyMapUtil", e3);
        }
        g.w("TPNativeKeyMapUtil", "convertToNativePropertyId, tpPropertyId: " + i2 + " not recognition, return -1");
        AppMethodBeat.o(189004);
        return -1;
    }

    public static int arj(int i2) {
        a.AbstractC2202a aVar;
        AppMethodBeat.i(189005);
        try {
            Class<?> cls = Class.forName(TPPlayerConnectionConstant.class.getName());
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.getType().toString().equals("int")) {
                    field.setAccessible(true);
                    if (i2 == field.getInt(cls) && (aVar = (a.AbstractC2202a) field.getAnnotation(a.AbstractC2202a.class)) != null) {
                        int value = aVar.value();
                        AppMethodBeat.o(189005);
                        return value;
                    }
                }
            }
        } catch (ClassNotFoundException e2) {
            g.e("TPNativeKeyMapUtil", e2);
        } catch (IllegalAccessException e3) {
            g.e("TPNativeKeyMapUtil", e3);
        }
        g.w("TPNativeKeyMapUtil", "convertToNativeConnectionAction, tpConnectionAction: " + i2 + " not recognition, return -1");
        AppMethodBeat.o(189005);
        return -1;
    }

    public static int ark(int i2) {
        a.b bVar;
        AppMethodBeat.i(189006);
        try {
            Class<?> cls = Class.forName(TPPlayerConnectionConstant.class.getName());
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.getType().toString().equals("int")) {
                    field.setAccessible(true);
                    if (i2 == field.getInt(cls) && (bVar = (a.b) field.getAnnotation(a.b.class)) != null) {
                        int value = bVar.value();
                        AppMethodBeat.o(189006);
                        return value;
                    }
                }
            }
        } catch (ClassNotFoundException e2) {
            g.e("TPNativeKeyMapUtil", e2);
        } catch (IllegalAccessException e3) {
            g.e("TPNativeKeyMapUtil", e3);
        }
        g.w("TPNativeKeyMapUtil", "convertToNativeConnectionConfig, tpConnectionConfig: " + i2 + " not recognition, return -1");
        AppMethodBeat.o(189006);
        return -1;
    }
}
