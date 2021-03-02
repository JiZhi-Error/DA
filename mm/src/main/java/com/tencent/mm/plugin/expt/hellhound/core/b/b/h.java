package com.tencent.mm.plugin.expt.hellhound.core.b.b;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public final class h {
    public static List<Fragment> c(FragmentActivity fragmentActivity) {
        AppMethodBeat.i(220444);
        if (fragmentActivity == null) {
            AppMethodBeat.o(220444);
            return null;
        }
        g supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (supportFragmentManager == null) {
            AppMethodBeat.o(220444);
            return null;
        }
        List<Fragment> fragments = supportFragmentManager.getFragments();
        AppMethodBeat.o(220444);
        return fragments;
    }

    public static Fragment apl(String str) {
        AppMethodBeat.i(220445);
        if (str == null) {
            AppMethodBeat.o(220445);
            return null;
        }
        FragmentActivity cNA = b.cNA();
        if (cNA == null) {
            AppMethodBeat.o(220445);
            return null;
        }
        Fragment c2 = c(cNA, str);
        AppMethodBeat.o(220445);
        return c2;
    }

    public static Fragment c(FragmentActivity fragmentActivity, String str) {
        Fragment fragment;
        AppMethodBeat.i(122015);
        if (fragmentActivity == null || str == null) {
            AppMethodBeat.o(122015);
            return null;
        }
        g supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (supportFragmentManager == null) {
            AppMethodBeat.o(122015);
            return null;
        }
        List<Fragment> fragments = supportFragmentManager.getFragments();
        if (fragments == null) {
            AppMethodBeat.o(122015);
            return null;
        }
        Iterator<Fragment> it = fragments.iterator();
        while (true) {
            if (!it.hasNext()) {
                fragment = null;
                break;
            }
            fragment = it.next();
            if (fragment != null && str.equals(fragment.getClass().getCanonicalName())) {
                break;
            }
        }
        AppMethodBeat.o(122015);
        return fragment;
    }

    public static Fragment a(FragmentActivity fragmentActivity, int i2) {
        AppMethodBeat.i(220446);
        List<Fragment> c2 = c(fragmentActivity);
        if (c2 == null || c2.isEmpty() || i2 < 0 || i2 >= c2.size()) {
            AppMethodBeat.o(220446);
            return null;
        }
        Fragment a2 = a(i2, c2, fragmentActivity);
        AppMethodBeat.o(220446);
        return a2;
    }

    public static Fragment apm(String str) {
        AppMethodBeat.i(184332);
        if (str == null) {
            AppMethodBeat.o(184332);
            return null;
        } else if (!b.aoz(str)) {
            AppMethodBeat.o(184332);
            return null;
        } else {
            try {
                Method declaredMethod = Class.forName("com.tencent.mm.ui.LauncherUI").getDeclaredMethod("getCurrentTabIndex", new Class[0]);
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(null, new Object[0])).intValue();
                Log.i("HABBYGE-MALI.FragmentUtil", "getCurFragmentOfLauncherUI, index: %d", Integer.valueOf(intValue));
                FragmentActivity cNA = b.cNA();
                if (cNA == null) {
                    AppMethodBeat.o(184332);
                    return null;
                } else if (intValue <= 0) {
                    Fragment d2 = d(cNA);
                    AppMethodBeat.o(184332);
                    return d2;
                } else {
                    List<Fragment> fragments = cNA.getSupportFragmentManager().getFragments();
                    if (fragments == null) {
                        Log.e("HABBYGE-MALI.FragmentUtil", "getCurFragmentOfLauncherUI, fragmentList NULL");
                        AppMethodBeat.o(184332);
                        return null;
                    }
                    Fragment a2 = a(intValue, fragments, cNA);
                    AppMethodBeat.o(184332);
                    return a2;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(184332);
                return null;
            }
        }
    }

    private static Fragment a(int i2, List<Fragment> list, FragmentActivity fragmentActivity) {
        int size;
        Fragment fragment = null;
        AppMethodBeat.i(184333);
        if (list == null || list.isEmpty() || (size = list.size()) > 5) {
            AppMethodBeat.o(184333);
        } else if (i2 < 0 || i2 >= size) {
            AppMethodBeat.o(184333);
        } else {
            switch (i2) {
                case 0:
                    fragment = q(b.syW, list);
                    break;
                case 1:
                    fragment = q(b.syX, list);
                    break;
                case 2:
                    fragment = q(b.syY, list);
                    break;
                case 3:
                    fragment = q(b.syZ, list);
                    break;
                case 4:
                    fragment = q(b.sza, list);
                    break;
            }
            if (fragment == null) {
                try {
                    fragment = list.get(i2);
                    Log.i("HABBYGE-MALI.FragmentUtil", "getCurFragmentOfLauncherUI-1: %s", fragment.getClass().getCanonicalName());
                } catch (Exception e2) {
                    fragment = d(fragmentActivity);
                    Log.i("HABBYGE-MALI.FragmentUtil", "getCurFragmentOfLauncherUI-2: %s", fragment.getClass().getCanonicalName());
                }
            } else {
                Log.i("HABBYGE-MALI.FragmentUtil", "_getFragmentByIndex: %s", fragment.getClass().getCanonicalName());
            }
            AppMethodBeat.o(184333);
        }
        return fragment;
    }

    private static Fragment q(String str, List<Fragment> list) {
        AppMethodBeat.i(184334);
        for (Fragment fragment : list) {
            if (fragment != null && str.equals(fragment.getClass().getCanonicalName())) {
                AppMethodBeat.o(184334);
                return fragment;
            }
        }
        AppMethodBeat.o(184334);
        return null;
    }

    public static Fragment aa(Activity activity) {
        AppMethodBeat.i(184335);
        if (activity == null) {
            AppMethodBeat.o(184335);
            return null;
        }
        Fragment apm = apm(activity.getClass().getCanonicalName());
        AppMethodBeat.o(184335);
        return apm;
    }

    private static Fragment d(FragmentActivity fragmentActivity) {
        Fragment fragment;
        Fragment fragment2;
        Fragment fragment3 = null;
        AppMethodBeat.i(122017);
        if (fragmentActivity == null) {
            AppMethodBeat.o(122017);
        } else {
            try {
                Method declaredMethod = fragmentActivity.getClass().getDeclaredMethod("getCurrentFragmet", new Class[0]);
                declaredMethod.setAccessible(true);
                fragment = (Fragment) declaredMethod.invoke(fragmentActivity, new Object[0]);
                Log.i("HABBYGE-MALI.FragmentUtil", "getCurFragment, 1: %s", fragment.getClass().getCanonicalName());
            } catch (Exception e2) {
                fragment = null;
            }
            if (fragment == null) {
                g supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                if (supportFragmentManager == null) {
                    Log.e("HABBYGE-MALI.FragmentUtil", "getCurFragment, FragmentManager: NULL");
                    AppMethodBeat.o(122017);
                } else {
                    List<Fragment> fragments = supportFragmentManager.getFragments();
                    if (fragments == null) {
                        Log.e("HABBYGE-MALI.FragmentUtil", "_getCurrentFragmentFromSystem, fragmentList NULL");
                    } else {
                        Log.i("HABBYGE-MALI.FragmentUtil", "_getCurrentFragmentFromSystem, fragmentList: %d", Integer.valueOf(fragments.size()));
                        Iterator<Fragment> it = fragments.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                fragment2 = null;
                                break;
                            }
                            fragment2 = it.next();
                            if (fragment2 != null && fragment2.isAdded() && e(fragment2).booleanValue()) {
                                Log.i("HABBYGE-MALI.FragmentUtil", "_getCurrentFragmentFromSystem: %s", fragment2.getClass().getCanonicalName());
                                break;
                            }
                        }
                        fragment3 = fragment2;
                    }
                }
            } else {
                fragment3 = fragment;
            }
            AppMethodBeat.o(122017);
        }
        return fragment3;
    }

    private static Boolean e(Fragment fragment) {
        AppMethodBeat.i(122018);
        try {
            Method declaredMethod = Fragment.class.getDeclaredMethod("isMenuVisible", new Class[0]);
            declaredMethod.setAccessible(true);
            Boolean bool = (Boolean) declaredMethod.invoke(fragment, new Object[0]);
            AppMethodBeat.o(122018);
            return bool;
        } catch (Throwable th) {
            Log.printErrStackTrace("HABBYGE-MALI.FragmentUtil", th, "isMenuVisible", new Object[0]);
            Boolean bool2 = Boolean.FALSE;
            AppMethodBeat.o(122018);
            return bool2;
        }
    }

    static String GT(int i2) {
        switch (i2) {
            case 0:
                return "ff000001";
            case 1:
                return "ff000002";
            case 2:
                return "ff000003";
            case 3:
                return "ff000004";
            default:
                return "-1";
        }
    }

    public static Fragment cOk() {
        AppMethodBeat.i(220447);
        Fragment cOk = k.cOk();
        AppMethodBeat.o(220447);
        return cOk;
    }

    public static Fragment ab(Activity activity) {
        AppMethodBeat.i(220448);
        Fragment ab = k.ab(activity);
        AppMethodBeat.o(220448);
        return ab;
    }
}
