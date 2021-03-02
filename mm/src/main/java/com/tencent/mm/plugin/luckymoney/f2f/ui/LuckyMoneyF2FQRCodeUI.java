package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cj;
import com.tencent.mm.particles.b;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView;
import com.tencent.mm.plugin.luckymoney.model.ad;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class LuckyMoneyF2FQRCodeUI extends LuckyMoneyBaseUI implements ScreenShotUtil.ScreenShotCallback {
    private View agA;
    private MTimerHandler klF;
    private int[] kmr;
    private Bitmap mBitmap;
    private SensorManager mSensorManager;
    private DisplayMetrics metrics;
    private e nVN;
    private o.g qAd = new o.g() {
        /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.AnonymousClass9 */

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(65074);
            switch (menuItem.getItemId()) {
                case 1:
                    if (LuckyMoneyF2FQRCodeUI.this.ySb <= 0) {
                        h.cD(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.this.getString(R.string.ep8));
                        break;
                    } else {
                        LuckyMoneyF2FQRCodeUI.i(LuckyMoneyF2FQRCodeUI.this);
                        AppMethodBeat.o(65074);
                        return;
                    }
            }
            AppMethodBeat.o(65074);
        }
    };
    private String qwG;
    private String rCq;
    private int retCode;
    private String yQE;
    private Button yQO;
    private String yRZ;
    private ShuffleView ySA;
    private ShuffleView.c ySB;
    private List<View> ySC;
    private ViewGroup ySD;
    private ViewGroup ySE;
    private View ySF;
    private com.tencent.mm.plugin.luckymoney.f2f.a ySG;
    private long ySH;
    private String ySI;
    private ValueAnimator ySJ;
    private float ySK;
    private float ySL;
    private float ySM;
    private cj.a ySN = new cj.a() {
        /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.AnonymousClass1 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(65061);
            Map<String, String> parseXml = XmlParser.parseXml(z.a(aVar.heO.KHn), "sysmsg", null);
            if (parseXml != null) {
                String str = parseXml.get(".sysmsg.sendId");
                final String str2 = parseXml.get(".sysmsg.username");
                final String str3 = parseXml.get(".sysmsg.amount");
                final String str4 = parseXml.get(".sysmsg.receiveId");
                if (Util.getInt(parseXml.get(".sysmsg.islucky"), 0) > 0) {
                    LuckyMoneyF2FQRCodeUI.this.ySI = str2;
                }
                if (!Util.isNullOrNil(str, str2, str3)) {
                    LuckyMoneyF2FQRCodeUI.this.runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(65060);
                            if (!LuckyMoneyF2FQRCodeUI.this.ySv.contains(str4)) {
                                LuckyMoneyF2FQRCodeUI.this.ySv.add(0, str4);
                                if (!ab.IS(str2)) {
                                    i iVar = new i();
                                    iVar.username = str2;
                                    p.aYB().b(iVar);
                                }
                                LuckyMoneyF2FQRCodeUI.this.ySw.put(str4, str2);
                                ShuffleView shuffleView = LuckyMoneyF2FQRCodeUI.this.ySA;
                                if (shuffleView.yTy.size() > 0) {
                                    if (shuffleView.yTA.isStarted()) {
                                        shuffleView.yTA.end();
                                    }
                                    if (shuffleView.rnC.isStarted()) {
                                        shuffleView.rnC.end();
                                    }
                                    if (shuffleView.kmM != null) {
                                        shuffleView.yTE = shuffleView.kmM;
                                        shuffleView.yTy.remove(shuffleView.yTE);
                                        if (shuffleView.tMD != null) {
                                            shuffleView.tMD.start();
                                        }
                                        shuffleView.PJ(shuffleView.yTG);
                                        if (shuffleView.yTJ > 0) {
                                            shuffleView.yTG = shuffleView.eeU();
                                            shuffleView.kmM = shuffleView.yTy.get(shuffleView.yTG);
                                        } else {
                                            shuffleView.kmM = null;
                                            shuffleView.yTG = 0;
                                        }
                                    } else {
                                        shuffleView.PH(shuffleView.eeU());
                                        shuffleView.yTE = shuffleView.kmM;
                                        shuffleView.yTA.addListener(new Animator.AnimatorListener() {
                                            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.AnonymousClass5 */

                                            public final void onAnimationStart(Animator animator) {
                                            }

                                            public final void onAnimationEnd(Animator animator) {
                                                AppMethodBeat.i(65120);
                                                ShuffleView.this.yTy.remove(ShuffleView.this.yTE);
                                                if (ShuffleView.this.tMD != null) {
                                                    ShuffleView.this.tMD.start();
                                                }
                                                ShuffleView.f(ShuffleView.this, ShuffleView.this.yTG);
                                                if (ShuffleView.this.yTJ > 0) {
                                                    ShuffleView.this.yTG = ShuffleView.y(ShuffleView.this);
                                                    ShuffleView.this.kmM = (View) ShuffleView.this.yTy.get(ShuffleView.this.yTG);
                                                    AppMethodBeat.o(65120);
                                                    return;
                                                }
                                                ShuffleView.this.kmM = null;
                                                ShuffleView.this.yTG = 0;
                                                AppMethodBeat.o(65120);
                                            }

                                            public final void onAnimationCancel(Animator animator) {
                                            }

                                            public final void onAnimationRepeat(Animator animator) {
                                            }
                                        });
                                    }
                                }
                                LuckyMoneyF2FQRCodeUI.this.ySC.remove(LuckyMoneyF2FQRCodeUI.this.ySA.getExitView());
                                LuckyMoneyF2FQRCodeUI.this.klF.startTimer(0, Util.MILLSECONDS_OF_MINUTE);
                                LuckyMoneyF2FQRCodeUI.this.ySx.add(new Pair(str2, Integer.valueOf(Util.getInt(str3, 0))));
                            }
                            AppMethodBeat.o(65060);
                        }
                    });
                }
            }
            AppMethodBeat.o(65061);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private o.f ySO = new o.f() {
        /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.AnonymousClass8 */

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(65073);
            if (Util.isNullOrNil(LuckyMoneyF2FQRCodeUI.this.yRZ)) {
                mVar.kV(1, R.string.ep7);
                AppMethodBeat.o(65073);
                return;
            }
            mVar.a(1, LuckyMoneyF2FQRCodeUI.this.getString(R.string.ep7), LuckyMoneyF2FQRCodeUI.this.yRZ, 0);
            AppMethodBeat.o(65073);
        }
    };
    private Bitmap ySP;
    private Bitmap ySQ;
    private Bitmap ySR;
    private Bitmap ySS;
    private Bitmap yST;
    private Bitmap ySU;
    private Bitmap ySV;
    private Bitmap ySW;
    private Bitmap ySX;
    private Bitmap ySY;
    private Bitmap ySZ;
    private String ySa;
    private int ySb;
    private View ySm;
    private View ySn;
    private ImageView ySo;
    private TextView ySp;
    private TextView ySq;
    private ImageView ySr;
    private TextView ySs;
    private TextView ySt;
    private HorizontalListViewV2 ySu;
    private List<String> ySv;
    private Map<String, String> ySw;
    private Queue<Pair<String, Integer>> ySx;
    private a ySy;
    private TextView ySz;
    private Bitmap yTa;
    private b yTb = new b() {
        /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.AnonymousClass10 */

        @Override // com.tencent.mm.particles.b
        public final com.tencent.mm.particles.a.b a(Random random) {
            AppMethodBeat.i(65075);
            int nextInt = random.nextInt(100);
            if (nextInt < 16) {
                if (LuckyMoneyF2FQRCodeUI.this.ySS == null) {
                    LuckyMoneyF2FQRCodeUI.this.ySS = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.ccr, 36);
                }
                com.tencent.mm.particles.a.a aVar = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ySS);
                AppMethodBeat.o(65075);
                return aVar;
            } else if (nextInt < 33) {
                if (LuckyMoneyF2FQRCodeUI.this.yST == null) {
                    LuckyMoneyF2FQRCodeUI.this.yST = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.ccs, 36);
                }
                com.tencent.mm.particles.a.a aVar2 = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.this.yST);
                AppMethodBeat.o(65075);
                return aVar2;
            } else if (nextInt < 50) {
                if (LuckyMoneyF2FQRCodeUI.this.ySU == null) {
                    LuckyMoneyF2FQRCodeUI.this.ySU = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.cct, 36);
                }
                com.tencent.mm.particles.a.a aVar3 = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ySU);
                AppMethodBeat.o(65075);
                return aVar3;
            } else if (nextInt < 70) {
                if (LuckyMoneyF2FQRCodeUI.this.ySP == null) {
                    LuckyMoneyF2FQRCodeUI.this.ySP = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.ccm, 36);
                }
                com.tencent.mm.particles.a.a aVar4 = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ySP);
                AppMethodBeat.o(65075);
                return aVar4;
            } else if (nextInt < 90) {
                if (LuckyMoneyF2FQRCodeUI.this.ySQ == null) {
                    LuckyMoneyF2FQRCodeUI.this.ySQ = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.ccn, 36);
                }
                com.tencent.mm.particles.a.a aVar5 = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ySQ);
                AppMethodBeat.o(65075);
                return aVar5;
            } else {
                if (LuckyMoneyF2FQRCodeUI.this.ySR == null) {
                    LuckyMoneyF2FQRCodeUI.this.ySR = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.cco, 36);
                }
                com.tencent.mm.particles.a.a aVar6 = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ySR);
                AppMethodBeat.o(65075);
                return aVar6;
            }
        }
    };
    private b yTc = new b() {
        /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.AnonymousClass11 */

        @Override // com.tencent.mm.particles.b
        public final com.tencent.mm.particles.a.b a(Random random) {
            AppMethodBeat.i(65076);
            int nextInt = random.nextInt(100);
            if (nextInt < 10) {
                if (LuckyMoneyF2FQRCodeUI.this.ySY == null) {
                    LuckyMoneyF2FQRCodeUI.this.ySY = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.ccr, 32);
                }
                com.tencent.mm.particles.a.a aVar = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ySY);
                AppMethodBeat.o(65076);
                return aVar;
            } else if (nextInt < 20) {
                if (LuckyMoneyF2FQRCodeUI.this.ySZ == null) {
                    LuckyMoneyF2FQRCodeUI.this.ySZ = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.ccs, 32);
                }
                com.tencent.mm.particles.a.a aVar2 = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ySZ);
                AppMethodBeat.o(65076);
                return aVar2;
            } else if (nextInt < 30) {
                if (LuckyMoneyF2FQRCodeUI.this.yTa == null) {
                    LuckyMoneyF2FQRCodeUI.this.yTa = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.cct, 32);
                }
                com.tencent.mm.particles.a.a aVar3 = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.this.yTa);
                AppMethodBeat.o(65076);
                return aVar3;
            } else if (nextInt < 50) {
                if (LuckyMoneyF2FQRCodeUI.this.ySV == null) {
                    LuckyMoneyF2FQRCodeUI.this.ySV = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.ccm, 32);
                }
                com.tencent.mm.particles.a.a aVar4 = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ySV);
                AppMethodBeat.o(65076);
                return aVar4;
            } else if (nextInt < 75) {
                if (LuckyMoneyF2FQRCodeUI.this.ySW == null) {
                    LuckyMoneyF2FQRCodeUI.this.ySW = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.ccn, 32);
                }
                com.tencent.mm.particles.a.a aVar5 = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ySW);
                AppMethodBeat.o(65076);
                return aVar5;
            } else {
                if (LuckyMoneyF2FQRCodeUI.this.ySX == null) {
                    LuckyMoneyF2FQRCodeUI.this.ySX = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, R.drawable.cco, 32);
                }
                com.tencent.mm.particles.a.a aVar6 = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.this.ySX);
                AppMethodBeat.o(65076);
                return aVar6;
            }
        }
    };
    final SensorEventListener yTd = new SensorEventListener() {
        /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.AnonymousClass7 */
        float aTE;
        final int yTi = 3;
        float yTj = ((float) com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), R.dimen.ib));
        int yTk;
        ValueAnimator yTl;

        {
            AppMethodBeat.i(65070);
            AppMethodBeat.o(65070);
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            float f2 = -3.0f;
            AppMethodBeat.i(65071);
            if (sensorEvent.sensor.getType() == 1) {
                if (LuckyMoneyF2FQRCodeUI.this.ySb <= 0) {
                    AppMethodBeat.o(65071);
                    return;
                }
                if (this.yTk == 0) {
                    this.yTk = com.tencent.mm.pluginsdk.h.eu(LuckyMoneyF2FQRCodeUI.this) + ((int) this.yTj);
                }
                float f3 = sensorEvent.values[1];
                if (((double) Math.abs(f3 - this.aTE)) < 0.05d) {
                    AppMethodBeat.o(65071);
                    return;
                }
                this.aTE = f3;
                Log.d("LuckyMoneyF2FQRCodeUI", "[onSensorChanged] y:%s ", Float.valueOf(f3));
                if (f3 >= -3.0f) {
                    if (f3 > 0.0f) {
                        f2 = 0.0f;
                    } else {
                        f2 = f3;
                    }
                }
                float f4 = ((f2 / 3.0f) * ((float) this.yTk)) + ((float) this.yTk);
                Log.d("LuckyMoneyF2FQRCodeUI", "paddingTop:%s nowPaddingTop:%s", Float.valueOf(f4), Integer.valueOf(LuckyMoneyF2FQRCodeUI.this.ySm.getPaddingTop()));
                if (this.yTl != null) {
                    this.yTl.cancel();
                }
                this.yTl = ValueAnimator.ofFloat((float) LuckyMoneyF2FQRCodeUI.this.ySm.getPaddingTop(), f4).setDuration(200L);
                this.yTl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.AnonymousClass7.AnonymousClass1 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(65069);
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        LuckyMoneyF2FQRCodeUI.this.ySm.setPadding(LuckyMoneyF2FQRCodeUI.this.ySm.getPaddingLeft(), (int) floatValue, LuckyMoneyF2FQRCodeUI.this.ySm.getPaddingRight(), LuckyMoneyF2FQRCodeUI.this.ySm.getPaddingBottom());
                        float f2 = floatValue / ((float) AnonymousClass7.this.yTk);
                        if (f2 <= 1.0f) {
                            LuckyMoneyF2FQRCodeUI.this.ySs.setAlpha((1.0f - f2) + LuckyMoneyF2FQRCodeUI.this.ySM);
                            LuckyMoneyF2FQRCodeUI.this.ySt.setAlpha(f2 * LuckyMoneyF2FQRCodeUI.this.ySM);
                            AppMethodBeat.o(65069);
                            return;
                        }
                        LuckyMoneyF2FQRCodeUI.this.ySs.setAlpha(LuckyMoneyF2FQRCodeUI.this.ySM);
                        LuckyMoneyF2FQRCodeUI.this.ySt.setAlpha(LuckyMoneyF2FQRCodeUI.this.ySM);
                        AppMethodBeat.o(65069);
                    }
                });
                this.yTl.start();
            }
            AppMethodBeat.o(65071);
        }

        public final void onAccuracyChanged(Sensor sensor, int i2) {
            AppMethodBeat.i(65072);
            Log.i("LuckyMoneyF2FQRCodeUI", "onAccuracyChanged");
            AppMethodBeat.o(65072);
        }
    };

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyF2FQRCodeUI() {
        AppMethodBeat.i(65085);
        AppMethodBeat.o(65085);
    }

    static /* synthetic */ void K(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        AppMethodBeat.i(65100);
        luckyMoneyF2FQRCodeUI.eeP();
        AppMethodBeat.o(65100);
    }

    static /* synthetic */ void M(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        AppMethodBeat.i(65101);
        luckyMoneyF2FQRCodeUI.eeR();
        AppMethodBeat.o(65101);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(65086);
        super.onCreate(bundle);
        this.metrics = getResources().getDisplayMetrics();
        this.ySv = new ArrayList();
        this.ySw = new HashMap();
        this.ySx = new LinkedList();
        this.ySC = new ArrayList();
        this.kmr = new int[6];
        int[] iArr = this.kmr;
        iArr[0] = iArr[0] + 1;
        this.klF = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.AnonymousClass12 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(65077);
                LuckyMoneyF2FQRCodeUI.this.doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.e(), false);
                AppMethodBeat.o(65077);
                return true;
            }
        }, true);
        this.agA = findViewById(R.id.f16);
        this.ySm = findViewById(R.id.jnh);
        this.ySt = (TextView) findViewById(R.id.f12);
        this.ySs = (TextView) findViewById(R.id.f13);
        this.ySM = this.ySt.getAlpha();
        this.ySr = (ImageView) this.agA.findViewById(R.id.f11);
        this.ySu = (HorizontalListViewV2) findViewById(R.id.f14);
        this.ySy = new a(this, (byte) 0);
        this.ySu.setAdapter((ListAdapter) this.ySy);
        this.ySu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.AnonymousClass13 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(65078);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FQRCodeUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Intent intent = new Intent(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyBeforeDetailUI.class);
                intent.putExtra("key_sendid", LuckyMoneyF2FQRCodeUI.this.yQE);
                LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI = LuckyMoneyF2FQRCodeUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyF2FQRCodeUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FQRCodeUI$7", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                luckyMoneyF2FQRCodeUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyF2FQRCodeUI, "com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FQRCodeUI$7", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FQRCodeUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(65078);
            }
        });
        this.ySu.setOnScrollStateChangedListener(new HorizontalListViewV2.d() {
            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.AnonymousClass14 */

            @Override // com.tencent.mm.ui.base.HorizontalListViewV2.d
            public final void a(HorizontalListViewV2.d.a aVar) {
                AppMethodBeat.i(65079);
                if (aVar == HorizontalListViewV2.d.a.SCROLL_STATE_IDLE && LuckyMoneyF2FQRCodeUI.this.ySv.size() >= 5 && ((long) LuckyMoneyF2FQRCodeUI.this.ySv.size()) < LuckyMoneyF2FQRCodeUI.this.ySH && LuckyMoneyF2FQRCodeUI.this.ySu.getLastVisiblePosition() == LuckyMoneyF2FQRCodeUI.this.ySv.size() - 1 && !Util.isNullOrNil(LuckyMoneyF2FQRCodeUI.this.yQE)) {
                    LuckyMoneyF2FQRCodeUI.this.doSceneProgress(new ao(LuckyMoneyF2FQRCodeUI.this.yQE, 5, LuckyMoneyF2FQRCodeUI.this.ySv.size(), null, "v1.0"));
                }
                AppMethodBeat.o(65079);
            }
        });
        this.yQO = (Button) findViewById(R.id.f10);
        this.yQO.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(65080);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FQRCodeUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyPrepareUI.class);
                intent.putExtra("key_from", 2);
                LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI = LuckyMoneyF2FQRCodeUI.this;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyF2FQRCodeUI, bl.axQ(), "com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FQRCodeUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                luckyMoneyF2FQRCodeUI.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(luckyMoneyF2FQRCodeUI, "com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FQRCodeUI$9", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FQRCodeUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65080);
            }
        });
        this.ySz = (TextView) findViewById(R.id.f18);
        this.ySn = findViewById(R.id.f17);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(65062);
                LuckyMoneyF2FQRCodeUI.this.finish();
                AppMethodBeat.o(65062);
                return true;
            }
        });
        setMMTitle(getString(R.string.epj));
        addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(65063);
                LuckyMoneyF2FQRCodeUI.this.nVN = new e((Context) LuckyMoneyF2FQRCodeUI.this, 1, false);
                LuckyMoneyF2FQRCodeUI.this.nVN.HLX = LuckyMoneyF2FQRCodeUI.this.ySO;
                LuckyMoneyF2FQRCodeUI.this.nVN.HLY = LuckyMoneyF2FQRCodeUI.this.qAd;
                LuckyMoneyF2FQRCodeUI.this.nVN.dGm();
                AppMethodBeat.o(65063);
                return true;
            }
        });
        setActionbarColor(getResources().getColor(R.color.yd));
        hideActionbarLine();
        this.ySD = (ViewGroup) findViewById(R.id.f0v);
        this.ySE = (ViewGroup) findViewById(R.id.f0u);
        this.ySF = findViewById(R.id.f0x);
        this.ySF.setAlpha(0.0f);
        this.mSensorManager = (SensorManager) MMApplicationContext.getContext().getSystemService("sensor");
        this.mSensorManager.registerListener(this.yTd, this.mSensorManager.getDefaultSensor(1), 3);
        this.ySG = new com.tencent.mm.plugin.luckymoney.f2f.a();
        this.ySA = (ShuffleView) findViewById(R.id.f19);
        this.ySB = new ShuffleView.c();
        this.ySB.yTY = 4;
        this.ySB.yTW = 2;
        this.ySB.yTX = 4;
        this.ySB.yTZ = 300;
        this.ySB.scaleY = 0.0f;
        this.ySA.setShuffleSetting(this.ySB);
        ShuffleView.metrics = this.metrics;
        this.ySA.setExitAnimator(ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L));
        this.ySA.setExitAnimatorListener(new ShuffleView.a() {
            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.a
            public final void a(ValueAnimator valueAnimator, View view) {
                AppMethodBeat.i(65064);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue == 0.0f) {
                    LuckyMoneyF2FQRCodeUI.this.ySK = view.getTranslationX();
                    LuckyMoneyF2FQRCodeUI.this.ySL = view.getTranslationY();
                    view.findViewById(R.id.f1_).setVisibility(0);
                }
                view.setTranslationX((1.0f - floatValue) * LuckyMoneyF2FQRCodeUI.this.ySK);
                view.setTranslationY(((1.0f - floatValue) * LuckyMoneyF2FQRCodeUI.this.ySL) - ((((float) LuckyMoneyF2FQRCodeUI.this.ySA.getHeight()) + (LuckyMoneyF2FQRCodeUI.this.ySL * 8.0f)) * floatValue));
                view.setScaleX((0.5f * floatValue) + 1.0f);
                view.setScaleY((0.5f * floatValue) + 1.0f);
                Pair pair = (Pair) LuckyMoneyF2FQRCodeUI.this.ySx.peek();
                if (pair != null && !Util.isNullOrNil(LuckyMoneyF2FQRCodeUI.this.ySI) && LuckyMoneyF2FQRCodeUI.this.ySI.equals(pair.first)) {
                    LuckyMoneyF2FQRCodeUI.this.ySF.setAlpha(floatValue);
                }
                Log.i("LuckyMoneyF2FQRCodeUI", "fireworkBottomLayer %f", Float.valueOf(floatValue));
                if (floatValue >= 0.9f) {
                    view.setAlpha((1.0f - floatValue) * 10.0f);
                    LuckyMoneyF2FQRCodeUI.this.ySn.setAlpha(1.0f - ((1.0f - floatValue) * 10.0f));
                    LuckyMoneyF2FQRCodeUI.this.ySn.setScaleX(floatValue);
                    LuckyMoneyF2FQRCodeUI.this.ySn.setScaleY(floatValue);
                    LuckyMoneyF2FQRCodeUI.this.ySn.setVisibility(0);
                }
                if (floatValue == 1.0f) {
                    LuckyMoneyF2FQRCodeUI.this.ySG.Df("packet_received.m4a");
                    LuckyMoneyF2FQRCodeUI.this.ySA.removeView(LuckyMoneyF2FQRCodeUI.this.ySA.getExitView());
                    LuckyMoneyF2FQRCodeUI.H(LuckyMoneyF2FQRCodeUI.this);
                    LuckyMoneyF2FQRCodeUI.this.ySJ.start();
                }
                AppMethodBeat.o(65064);
            }
        });
        this.ySA.setCardListener(new ShuffleView.b() {
            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.b
            public final void gS(int i2, int i3) {
                AppMethodBeat.i(65065);
                if (i3 == 8) {
                    LuckyMoneyF2FQRCodeUI.this.ySG.Df("music" + (i2 + 1) + ".m4a");
                    int[] iArr = LuckyMoneyF2FQRCodeUI.this.kmr;
                    iArr[4] = iArr[4] + 1;
                    AppMethodBeat.o(65065);
                    return;
                }
                LuckyMoneyF2FQRCodeUI.this.ySG.Df("touch_card.m4a");
                int[] iArr2 = LuckyMoneyF2FQRCodeUI.this.kmr;
                iArr2[2] = iArr2[2] + 1;
                AppMethodBeat.o(65065);
            }

            @Override // com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.b
            public final void PE(int i2) {
                AppMethodBeat.i(65066);
                LuckyMoneyF2FQRCodeUI.K(LuckyMoneyF2FQRCodeUI.this);
                if (i2 != 8) {
                    LuckyMoneyF2FQRCodeUI.this.ySG.Df("select_card.m4a");
                    int[] iArr = LuckyMoneyF2FQRCodeUI.this.kmr;
                    iArr[3] = iArr[3] + 1;
                    AppMethodBeat.o(65066);
                    return;
                }
                int[] iArr2 = LuckyMoneyF2FQRCodeUI.this.kmr;
                iArr2[5] = iArr2[5] + 1;
                AppMethodBeat.o(65066);
            }

            @Override // com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView.b
            public final void gT(int i2, int i3) {
                AppMethodBeat.i(65067);
                if (i3 == 8) {
                    LuckyMoneyF2FQRCodeUI.this.ySG.Df("music" + (i2 + 1) + ".m4a");
                    AppMethodBeat.o(65067);
                    return;
                }
                LuckyMoneyF2FQRCodeUI.this.ySG.Df("select_card.m4a");
                AppMethodBeat.o(65067);
            }
        });
        eeQ();
        this.ySJ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ySJ.setDuration(300L);
        this.ySJ.setStartDelay(3000);
        this.ySJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.AnonymousClass6 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(65068);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                LuckyMoneyF2FQRCodeUI.this.ySn.setTranslationY(-0.5f * floatValue * ((float) LuckyMoneyF2FQRCodeUI.this.metrics.heightPixels));
                LuckyMoneyF2FQRCodeUI.this.ySF.setAlpha(1.0f - floatValue);
                if (floatValue == 1.0f) {
                    LuckyMoneyF2FQRCodeUI.this.ySn.setVisibility(8);
                    LuckyMoneyF2FQRCodeUI.this.ySn.setTranslationY(0.0f);
                    LuckyMoneyF2FQRCodeUI.M(LuckyMoneyF2FQRCodeUI.this);
                    LuckyMoneyF2FQRCodeUI.this.ySy.notifyDataSetChanged();
                    LuckyMoneyF2FQRCodeUI.this.ySu.gKt();
                }
                AppMethodBeat.o(65068);
            }
        });
        eeP();
        getWindow().addFlags(128);
        AppMethodBeat.o(65086);
    }

    private void eeP() {
        AppMethodBeat.i(65087);
        if (!Util.isNullOrNil(this.rCq)) {
            this.mBitmap = com.tencent.mm.by.a.a.ct(this, this.rCq);
            this.ySr.setImageBitmap(this.mBitmap);
        }
        if (this.ySb <= 0) {
            this.ySr.setPadding(com.tencent.mm.cb.a.fromDPToPix((Context) this, 5), com.tencent.mm.cb.a.fromDPToPix((Context) this, 5), com.tencent.mm.cb.a.fromDPToPix((Context) this, 5), com.tencent.mm.cb.a.fromDPToPix((Context) this, 5));
            this.ySr.setImageResource(R.drawable.ccl);
            this.ySz.setVisibility(8);
            this.yQO.setVisibility(0);
            this.ySs.setVisibility(4);
            this.ySm.setPadding(this.ySm.getPaddingLeft(), com.tencent.mm.pluginsdk.h.eu(this), this.ySm.getPaddingRight(), this.ySm.getPaddingBottom());
            if (this.ySv.size() > 0) {
                com.tencent.mm.plugin.finder.report.live.m.vli.a(s.bh.EXPOSE_RED_PACKET_OVER_INTERCEPT_UI, s.bg.UNKNOWN, true);
                this.ySt.setText(getString(R.string.epb));
                AppMethodBeat.o(65087);
                return;
            }
            this.ySt.setText(getString(R.string.epc));
            AppMethodBeat.o(65087);
            return;
        }
        this.ySr.setPadding(0, 0, 0, 0);
        this.ySs.setText(getString(R.string.eph));
        this.ySs.setVisibility(0);
        this.ySt.setText(getString(R.string.eph));
        this.ySz.setText(getString(R.string.epg, new Object[]{Integer.valueOf(this.ySb)}));
        this.ySz.setVisibility(0);
        this.yQO.setVisibility(8);
        AppMethodBeat.o(65087);
    }

    private void eeQ() {
        AppMethodBeat.i(65088);
        HashSet hashSet = new HashSet();
        hashSet.add("touch_card.m4a");
        hashSet.add("select_card.m4a");
        for (int i2 = 1; i2 <= 8; i2++) {
            hashSet.add("music" + i2 + ".m4a");
        }
        hashSet.add("packet_received.m4a");
        hashSet.add("most_lucky.m4a");
        hashSet.add("whistle.m4a");
        com.tencent.mm.plugin.luckymoney.f2f.a aVar = this.ySG;
        g.aAk().postToWorker(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005b: INVOKE  
              (wrap: com.tencent.mm.sdk.platformtools.MMHandlerThread : 0x0052: INVOKE  (r3v0 com.tencent.mm.sdk.platformtools.MMHandlerThread) =  type: STATIC call: com.tencent.mm.kernel.g.aAk():com.tencent.mm.sdk.platformtools.MMHandlerThread)
              (wrap: com.tencent.mm.plugin.luckymoney.f2f.a$1 : 0x0058: CONSTRUCTOR  (r4v0 com.tencent.mm.plugin.luckymoney.f2f.a$1) = 
              (r0v7 'aVar' com.tencent.mm.plugin.luckymoney.f2f.a)
              (r1v0 'hashSet' java.util.HashSet)
              (wrap: java.lang.ref.WeakReference : 0x004f: CONSTRUCTOR  (r2v1 java.lang.ref.WeakReference) = (r6v0 'this' com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI A[IMMUTABLE_TYPE, THIS]) call: java.lang.ref.WeakReference.<init>(java.lang.Object):void type: CONSTRUCTOR)
             call: com.tencent.mm.plugin.luckymoney.f2f.a.1.<init>(com.tencent.mm.plugin.luckymoney.f2f.a, java.util.Set, java.lang.ref.WeakReference):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToWorker(java.lang.Runnable):int in method: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.eeQ():void, file: classes6.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0058: CONSTRUCTOR  (r4v0 com.tencent.mm.plugin.luckymoney.f2f.a$1) = 
              (r0v7 'aVar' com.tencent.mm.plugin.luckymoney.f2f.a)
              (r1v0 'hashSet' java.util.HashSet)
              (wrap: java.lang.ref.WeakReference : 0x004f: CONSTRUCTOR  (r2v1 java.lang.ref.WeakReference) = (r6v0 'this' com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI A[IMMUTABLE_TYPE, THIS]) call: java.lang.ref.WeakReference.<init>(java.lang.Object):void type: CONSTRUCTOR)
             call: com.tencent.mm.plugin.luckymoney.f2f.a.1.<init>(com.tencent.mm.plugin.luckymoney.f2f.a, java.util.Set, java.lang.ref.WeakReference):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.eeQ():void, file: classes6.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.luckymoney.f2f.a, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 108
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI.eeQ():void");
    }

    private void eeR() {
        AppMethodBeat.i(65089);
        int width = this.ySu.getWidth() - (this.ySv.size() * getResources().getDimensionPixelSize(R.dimen.f3063h));
        if (width > 0) {
            this.ySu.setPadding(width / 2, 0, width / 2, 0);
            AppMethodBeat.o(65089);
            return;
        }
        this.ySu.setPadding(0, 0, 0, 0);
        AppMethodBeat.o(65089);
    }

    private void eeS() {
        AppMethodBeat.i(65090);
        if (this.ySC.size() != this.ySb) {
            Log.i("LuckyMoneyF2FQRCodeUI", "shuffle cards: %d", Integer.valueOf(this.ySC.size()), Integer.valueOf(this.ySb));
            this.ySC.clear();
            for (int i2 = 0; i2 < this.ySb; i2++) {
                View inflate = LayoutInflater.from(this).inflate(R.layout.b3t, (ViewGroup) this.ySA, false);
                ((FrameLayout.LayoutParams) inflate.getLayoutParams()).gravity = 81;
                this.ySC.add(inflate);
            }
            this.ySA.setAllShuffleCards(this.ySC);
        }
        AppMethodBeat.o(65090);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(65091);
        super.onResume();
        doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.e(), true);
        this.klF.startTimer(Util.MILLSECONDS_OF_MINUTE);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("ffopenwxhb", this.ySN, true);
        addSceneEndListener(1990);
        addSceneEndListener(1987);
        addSceneEndListener(1971);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.85f) {
            attributes.screenBrightness = 0.85f;
            getWindow().setAttributes(attributes);
        }
        ScreenShotUtil.setScreenShotCallback(this, this);
        if (this.mSensorManager != null) {
            this.mSensorManager.registerListener(this.yTd, this.mSensorManager.getDefaultSensor(1), 3);
        }
        AppMethodBeat.o(65091);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(65092);
        super.onStop();
        this.klF.stopTimer();
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("ffopenwxhb", this.ySN, true);
        removeSceneEndListener(1990);
        removeSceneEndListener(1987);
        removeSceneEndListener(1971);
        ScreenShotUtil.setScreenShotCallback(this, null);
        AppMethodBeat.o(65092);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(65093);
        super.onPause();
        if (this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.yTd);
        }
        AppMethodBeat.o(65093);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(65094);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14007, Integer.valueOf(this.kmr[0]), Integer.valueOf(this.kmr[1]), Integer.valueOf(this.kmr[2]), Integer.valueOf(this.kmr[3]), Integer.valueOf(this.kmr[4]), Integer.valueOf(this.kmr[5]));
        com.tencent.mm.plugin.luckymoney.f2f.a aVar = this.ySG;
        aVar.stopped = true;
        aVar.yRy.release();
        getWindow().clearFlags(128);
        super.onDestroy();
        AppMethodBeat.o(65094);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b3u;
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
    public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(65095);
        Log.i("LuckyMoneyF2FQRCodeUI", "errType: %d,errCode: %d,errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.e) {
                Log.d("LuckyMoneyF2FQRCodeUI", "sendId:" + this.yQE);
                if (!Util.isNullOrNil(this.yQE, ((com.tencent.mm.plugin.luckymoney.f2f.a.e) qVar).yQE) && !this.yQE.equals(((com.tencent.mm.plugin.luckymoney.f2f.a.e) qVar).yQE)) {
                    this.ySv.clear();
                    this.ySw.clear();
                    this.ySx.clear();
                    this.ySy.notifyDataSetChanged();
                    this.ySI = "";
                }
                if (!Util.isNullOrNil(((com.tencent.mm.plugin.luckymoney.f2f.a.e) qVar).yQE)) {
                    this.yQE = ((com.tencent.mm.plugin.luckymoney.f2f.a.e) qVar).yQE;
                }
                this.rCq = ((com.tencent.mm.plugin.luckymoney.f2f.a.e) qVar).rCq;
                this.ySb = ((com.tencent.mm.plugin.luckymoney.f2f.a.e) qVar).ySb;
                this.ySa = ((com.tencent.mm.plugin.luckymoney.f2f.a.e) qVar).ySa;
                this.yRZ = ((com.tencent.mm.plugin.luckymoney.f2f.a.e) qVar).yRZ;
                eeP();
                eeS();
                if (this.ySb == 0) {
                    this.klF.stopTimer();
                }
                if (this.ySv.size() == 0 && !Util.isNullOrNil(this.yQE)) {
                    doSceneProgress(new ao(this.yQE, 5, 0, null, "v1.0"), false);
                }
            } else if (qVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.a) {
                this.yQE = "";
                this.rCq = "";
                this.ySb = 0;
                this.ySv.clear();
                this.ySI = "";
                this.ySy.notifyDataSetChanged();
                eeP();
                eeS();
                this.klF.stopTimer();
                if (!Util.isNullOrNil(this.ySa)) {
                    com.tencent.mm.ui.base.h.cD(this, this.ySa);
                }
                this.yRZ = "";
            } else if (qVar instanceof ao) {
                this.ySH = ((ao) qVar).yWT.yVh;
                LinkedList<ad> linkedList = ((ao) qVar).yWT.yVw;
                if (linkedList != null && linkedList.size() > 0) {
                    for (int i4 = 0; i4 < linkedList.size(); i4++) {
                        ad adVar = linkedList.get(i4);
                        if (!Util.isNullOrNil(adVar.yVk) && !this.ySv.contains(adVar.yVk)) {
                            this.ySv.add(adVar.yVk);
                            String str2 = adVar.userName;
                            if (!Util.isNullOrNil(adVar.yWG)) {
                                this.ySI = str2;
                            }
                            this.ySw.put(adVar.yVk, str2);
                        }
                    }
                    eeR();
                    this.ySy.notifyDataSetChanged();
                }
            } else if (qVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.b) {
                Log.i("LuckyMoneyF2FQRCodeUI", "onSceneEnd NetSceneF2FLuckyMoneyInvalid");
                this.retCode = ((com.tencent.mm.plugin.luckymoney.f2f.a.b) qVar).dDN;
                this.qwG = ((com.tencent.mm.plugin.luckymoney.f2f.a.b) qVar).qwn;
                Log.i("LuckyMoneyF2FQRCodeUI", "retcode:%d", Integer.valueOf(i2), Integer.valueOf(i3), str);
            }
        } else if (!Util.isNullOrNil(str)) {
            com.tencent.mm.ui.base.h.c(this, str, getString(R.string.zb), true);
        }
        AppMethodBeat.o(65095);
        return true;
    }

    @Override // com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback
    public void onScreenShot(String str, long j2) {
        AppMethodBeat.i(213265);
        Log.i("LuckyMoneyF2FQRCodeUI", "screenShot");
        if (this.ySb > 0) {
            String str2 = this.rCq;
            Log.i("LuckyMoneyF2FQRCodeUI", "invalidQRCode");
            doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.b(str2), false);
            Log.i("LuckyMoneyF2FQRCodeUI", "getQRCode");
            doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.e(), false);
            eeP();
            int[] iArr = this.kmr;
            iArr[1] = iArr[1] + 1;
            com.tencent.mm.ui.base.h.c(this, getString(R.string.epi), null, true);
        }
        AppMethodBeat.o(213265);
    }

    /* access modifiers changed from: package-private */
    public class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI, byte b2) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(65081);
            int size = LuckyMoneyF2FQRCodeUI.this.ySv.size();
            AppMethodBeat.o(65081);
            return size;
        }

        private String getItem(int i2) {
            AppMethodBeat.i(65082);
            String str = (String) LuckyMoneyF2FQRCodeUI.this.ySv.get(i2);
            AppMethodBeat.o(65082);
            return str;
        }

        public final long getItemId(int i2) {
            return (long) i2;
        }

        public final View getView(int i2, View view, ViewGroup viewGroup) {
            C1466a aVar;
            AppMethodBeat.i(65083);
            if (view == null) {
                view = LayoutInflater.from(LuckyMoneyF2FQRCodeUI.this).inflate(R.layout.b3w, (ViewGroup) null);
                C1466a aVar2 = new C1466a();
                aVar2.jWS = (ImageView) view.findViewById(R.id.f15);
                aVar2.yTn = (ImageView) view.findViewById(R.id.f0y);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (C1466a) view.getTag();
            }
            String str = (String) LuckyMoneyF2FQRCodeUI.this.ySw.get(getItem(i2));
            af.a(aVar.jWS, (String) null, str);
            if (Util.isNullOrNil(LuckyMoneyF2FQRCodeUI.this.ySI) || !LuckyMoneyF2FQRCodeUI.this.ySI.equals(str)) {
                aVar.yTn.setVisibility(4);
            } else {
                aVar.yTn.setVisibility(0);
            }
            AppMethodBeat.o(65083);
            return view;
        }

        /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI$a$a  reason: collision with other inner class name */
        class C1466a {
            ImageView jWS;
            ImageView yTn;

            C1466a() {
            }
        }
    }

    static /* synthetic */ void i(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        AppMethodBeat.i(65097);
        luckyMoneyF2FQRCodeUI.doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.a(luckyMoneyF2FQRCodeUI.yQE), false);
        AppMethodBeat.o(65097);
    }

    static /* synthetic */ Bitmap a(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI, int i2, int i3) {
        AppMethodBeat.i(65098);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(luckyMoneyF2FQRCodeUI.getResources(), i2), i3, i3, false);
        AppMethodBeat.o(65098);
        return createScaledBitmap;
    }

    static /* synthetic */ void H(LuckyMoneyF2FQRCodeUI luckyMoneyF2FQRCodeUI) {
        AppMethodBeat.i(65099);
        luckyMoneyF2FQRCodeUI.ySo = (ImageView) luckyMoneyF2FQRCodeUI.ySn.findViewById(R.id.f45);
        luckyMoneyF2FQRCodeUI.ySp = (TextView) luckyMoneyF2FQRCodeUI.ySn.findViewById(R.id.f46);
        luckyMoneyF2FQRCodeUI.ySq = (TextView) luckyMoneyF2FQRCodeUI.ySn.findViewById(R.id.f3t);
        Pair<String, Integer> poll = luckyMoneyF2FQRCodeUI.ySx.poll();
        if (poll != null) {
            af.a(luckyMoneyF2FQRCodeUI.ySo, (String) null, (String) poll.first);
            af.a(luckyMoneyF2FQRCodeUI, luckyMoneyF2FQRCodeUI.ySp, af.Ir((String) poll.first));
            luckyMoneyF2FQRCodeUI.ySq.setText(f.formatMoney2f(((double) ((Integer) poll.second).intValue()) / 100.0d));
            if (!Util.isNullOrNil(luckyMoneyF2FQRCodeUI.ySI) && luckyMoneyF2FQRCodeUI.ySI.equals(poll.first)) {
                com.tencent.mm.particles.a.a(luckyMoneyF2FQRCodeUI.ySD, luckyMoneyF2FQRCodeUI.yTb).G(800, 100);
                com.tencent.mm.particles.a.a(luckyMoneyF2FQRCodeUI.ySE, luckyMoneyF2FQRCodeUI.yTc).G(800, 100);
                luckyMoneyF2FQRCodeUI.ySG.Df("most_lucky.m4a");
                if (((Integer) poll.second).intValue() >= 19000) {
                    luckyMoneyF2FQRCodeUI.ySG.Df("whistle.m4a");
                }
            }
        }
        AppMethodBeat.o(65099);
    }
}
