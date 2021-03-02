package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* access modifiers changed from: package-private */
public class c extends DataSetObservable {
    static final String LOG_TAG = c.class.getSimpleName();
    private static final Object ajg = new Object();
    private static final Map<String, c> ajh = new HashMap();
    final Object aji;
    final List<a> ajj;
    private final List<C0054c> ajk;
    final String ajl;
    private b ajm;
    private int ajn;
    boolean ajo;
    private boolean ajp;
    private boolean ajq;
    private boolean ajr;
    private d ajs;
    final Context mContext;
    private Intent mIntent;

    public interface b {
    }

    public interface d {
        boolean iV();
    }

    public final int iM() {
        int size;
        synchronized (this.aji) {
            iP();
            size = this.ajj.size();
        }
        return size;
    }

    public final ResolveInfo by(int i2) {
        ResolveInfo resolveInfo;
        synchronized (this.aji) {
            iP();
            resolveInfo = this.ajj.get(i2).resolveInfo;
        }
        return resolveInfo;
    }

    public final int a(ResolveInfo resolveInfo) {
        synchronized (this.aji) {
            iP();
            List<a> list = this.ajj;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2).resolveInfo == resolveInfo) {
                    return i2;
                }
            }
            return -1;
        }
    }

    public final Intent bz(int i2) {
        synchronized (this.aji) {
            if (this.mIntent == null) {
                return null;
            }
            iP();
            a aVar = this.ajj.get(i2);
            ComponentName componentName = new ComponentName(aVar.resolveInfo.activityInfo.packageName, aVar.resolveInfo.activityInfo.name);
            Intent intent = new Intent(this.mIntent);
            intent.setComponent(componentName);
            if (this.ajs != null) {
                new Intent(intent);
                if (this.ajs.iV()) {
                    return null;
                }
            }
            a(new C0054c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public final ResolveInfo iN() {
        synchronized (this.aji) {
            iP();
            if (this.ajj.isEmpty()) {
                return null;
            }
            return this.ajj.get(0).resolveInfo;
        }
    }

    private void iO() {
        if (!this.ajp) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.ajq) {
            this.ajq = false;
            if (!TextUtils.isEmpty(this.ajl)) {
                new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.ajk), this.ajl);
            }
        }
    }

    public final int getHistorySize() {
        int size;
        synchronized (this.aji) {
            iP();
            size = this.ajk.size();
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    public final void iP() {
        boolean iR = iR() | iS();
        iT();
        if (iR) {
            iQ();
            notifyChanged();
        }
    }

    private boolean iQ() {
        if (this.ajm == null || this.mIntent == null || this.ajj.isEmpty() || this.ajk.isEmpty()) {
            return false;
        }
        Collections.unmodifiableList(this.ajk);
        return true;
    }

    private boolean iR() {
        if (!this.ajr || this.mIntent == null) {
            return false;
        }
        this.ajr = false;
        this.ajj.clear();
        List<ResolveInfo> queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int size = queryIntentActivities.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.ajj.add(new a(queryIntentActivities.get(i2)));
        }
        return true;
    }

    private boolean iS() {
        if (!this.ajo || !this.ajq || TextUtils.isEmpty(this.ajl)) {
            return false;
        }
        this.ajo = false;
        this.ajp = true;
        iU();
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(C0054c cVar) {
        boolean add = this.ajk.add(cVar);
        if (add) {
            this.ajq = true;
            iT();
            iO();
            iQ();
            notifyChanged();
        }
        return add;
    }

    private void iT() {
        int size = this.ajk.size() - this.ajn;
        if (size > 0) {
            this.ajq = true;
            for (int i2 = 0; i2 < size; i2++) {
                this.ajk.remove(0);
            }
        }
    }

    /* renamed from: android.support.v7.widget.c$c  reason: collision with other inner class name */
    public static final class C0054c {
        public final ComponentName ajt;
        public final long time;
        public final float weight;

        public C0054c(String str, long j2, float f2) {
            this(ComponentName.unflattenFromString(str), j2, f2);
        }

        public C0054c(ComponentName componentName, long j2, float f2) {
            this.ajt = componentName;
            this.time = j2;
            this.weight = f2;
        }

        public final int hashCode() {
            return (((((this.ajt == null ? 0 : this.ajt.hashCode()) + 31) * 31) + ((int) (this.time ^ (this.time >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            C0054c cVar = (C0054c) obj;
            if (this.ajt == null) {
                if (cVar.ajt != null) {
                    return false;
                }
            } else if (!this.ajt.equals(cVar.ajt)) {
                return false;
            }
            if (this.time != cVar.time) {
                return false;
            }
            return Float.floatToIntBits(this.weight) == Float.floatToIntBits(cVar.weight);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append("; activity:").append(this.ajt);
            sb.append("; time:").append(this.time);
            sb.append("; weight:").append(new BigDecimal((double) this.weight));
            sb.append("]");
            return sb.toString();
        }
    }

    public static final class a implements Comparable<a> {
        public final ResolveInfo resolveInfo;
        public float weight;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(a aVar) {
            return Float.floatToIntBits(aVar.weight) - Float.floatToIntBits(this.weight);
        }

        public a(ResolveInfo resolveInfo2) {
            this.resolveInfo = resolveInfo2;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            return Float.floatToIntBits(this.weight) == Float.floatToIntBits(((a) obj).weight);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append("resolveInfo:").append(this.resolveInfo.toString());
            sb.append("; weight:").append(new BigDecimal((double) this.weight));
            sb.append("]");
            return sb.toString();
        }
    }

    private void iU() {
        try {
            FileInputStream openFileInput = this.mContext.openFileInput(this.ajl);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                int i2 = 0;
                while (i2 != 1 && i2 != 2) {
                    i2 = newPullParser.next();
                }
                if (!"historical-records".equals(newPullParser.getName())) {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
                List<C0054c> list = this.ajk;
                list.clear();
                while (true) {
                    int next = newPullParser.next();
                    if (next != 1) {
                        if (!(next == 3 || next == 4)) {
                            if (!"historical-record".equals(newPullParser.getName())) {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                            list.add(new C0054c(newPullParser.getAttributeValue(null, EnvConsts.ACTIVITY_MANAGER_SRVNAME), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                        }
                    } else if (openFileInput != null) {
                        try {
                            openFileInput.close();
                            return;
                        } catch (IOException e2) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } catch (XmlPullParserException e3) {
                new StringBuilder("Error reading historical recrod file: ").append(this.ajl);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (IOException e5) {
                new StringBuilder("Error reading historical recrod file: ").append(this.ajl);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e6) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e7) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e8) {
        }
    }

    /* access modifiers changed from: package-private */
    public final class e extends AsyncTask<Object, Void, Void> {
        e() {
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            List list = (List) objArr[0];
            try {
                FileOutputStream openFileOutput = c.this.mContext.openFileOutput((String) objArr[1], 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument(MimeTypeUtil.ContentType.DEFAULT_CHARSET, Boolean.TRUE);
                    newSerializer.startTag(null, "historical-records");
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        C0054c cVar = (C0054c) list.remove(0);
                        newSerializer.startTag(null, "historical-record");
                        newSerializer.attribute(null, EnvConsts.ACTIVITY_MANAGER_SRVNAME, cVar.ajt.flattenToString());
                        newSerializer.attribute(null, "time", String.valueOf(cVar.time));
                        newSerializer.attribute(null, "weight", String.valueOf(cVar.weight));
                        newSerializer.endTag(null, "historical-record");
                    }
                    newSerializer.endTag(null, "historical-records");
                    newSerializer.endDocument();
                    c.this.ajo = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e2) {
                        }
                    }
                } catch (IllegalArgumentException e3) {
                    String str = c.LOG_TAG;
                    new StringBuilder("Error writing historical record file: ").append(c.this.ajl);
                    c.this.ajo = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (IllegalStateException e5) {
                    String str2 = c.LOG_TAG;
                    new StringBuilder("Error writing historical record file: ").append(c.this.ajl);
                    c.this.ajo = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e6) {
                        }
                    }
                } catch (IOException e7) {
                    String str3 = c.LOG_TAG;
                    new StringBuilder("Error writing historical record file: ").append(c.this.ajl);
                    c.this.ajo = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e8) {
                        }
                    }
                } catch (Throwable th) {
                    c.this.ajo = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e9) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e10) {
                String str4 = c.LOG_TAG;
            }
            return null;
        }
    }
}
