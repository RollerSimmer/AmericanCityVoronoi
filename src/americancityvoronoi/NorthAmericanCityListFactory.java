/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import math.Point2;

/**
 *
 * @author rollersimmer
 */
public class NorthAmericanCityListFactory {
    
    public static boolean SHOULD_ADD_ALL_CITIES=true;
    public static boolean SHOULD_REMOVE_SMALL_CITIES=true;
    public static int MIN_POP_THRESHOLD=3;
    public static int MAX_POP_THRESHOLD=10;

    private static CityList result=null;

    private static void addSomeCities() {
        int XOFS=810;
        int YOFS=256;
        result.add(/*name*/new City(	"Albany"	,/*pos*/new Point2(	862-XOFS	,	273-YOFS	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(/*name*/new City(	"Buffalo"	,/*pos*/new Point2(	811-XOFS	,	271-YOFS	),/*reach*/	4	,/*pop100k*/	12	));
        result.add(/*name*/new City(	"Atl City"	,/*pos*/new Point2(	856-XOFS	,	306-YOFS	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(/*name*/new City(	"New York"	,/*pos*/new Point2(	861-XOFS	,	293-YOFS	),/*reach*/	16	,/*pop100k*/	236	));
        result.add(/*name*/new City(	"Philadelphia"	,/*pos*/new Point2(	849-XOFS	,	300-YOFS	),/*reach*/	9	,/*pop100k*/	67	));
    }


    private static void addAllCities() {
        
        result.add(new City(/*name*/	"Abilene"	,/*pos*/new Point2(	601	,	344	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Albany"	,/*pos*/new Point2(	861	,	242	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Albuquerque"	,/*pos*/new Point2(	532	,	317	),/*reach*/	3	,/*pop100k*/	12	));
        result.add(new City(/*name*/	"Alexandria, LA"	,/*pos*/new Point2(	674	,	355	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Amarillo"	,/*pos*/new Point2(	580	,	316	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Anchorage"	,/*pos*/new Point2(	100	,	56	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Anniston-Gadsden"	,/*pos*/new Point2(	739	,	330	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Atlanta"	,/*pos*/new Point2(	754	,	331	),/*reach*/	5	,/*pop100k*/	62	));
        result.add(new City(/*name*/	"Atlantic City"	,/*pos*/new Point2(	854	,	275	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Augusta, GA"	,/*pos*/new Point2(	778	,	335	),/*reach*/	3	,/*pop100k*/	6	));
        result.add(new City(/*name*/	"Augusta, ME"	,/*pos*/new Point2(	901	,	225	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Austin"	,/*pos*/new Point2(	621	,	365	),/*reach*/	4	,/*pop100k*/	19	));
        result.add(new City(/*name*/	"Bakersfield"	,/*pos*/new Point2(	408	,	315	),/*reach*/	3	,/*pop100k*/	9	));
        result.add(new City(/*name*/	"Bangor"	,/*pos*/new Point2(	911	,	220	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Barrie"	,/*pos*/new Point2(	801	,	225	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Baton Rouge"	,/*pos*/new Point2(	687	,	364	),/*reach*/	3	,/*pop100k*/	8	));
        result.add(new City(/*name*/	"Battle Creek"	,/*pos*/new Point2(	747	,	245	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Bay Area"	,/*pos*/new Point2(	374	,	291	),/*reach*/	5	,/*pop100k*/	83	));
        result.add(new City(/*name*/	"Billings"	,/*pos*/new Point2(	513	,	210	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Birmingham"	,/*pos*/new Point2(	730	,	333	),/*reach*/	3	,/*pop100k*/	13	));
        result.add(new City(/*name*/	"Bismark"	,/*pos*/new Point2(	591	,	200	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Boise"	,/*pos*/new Point2(	436	,	232	),/*reach*/	3	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Boston"	,/*pos*/new Point2(	888	,	245	),/*reach*/	5	,/*pop100k*/	75	));
        result.add(new City(/*name*/	"Brownsville"	,/*pos*/new Point2(	624	,	408	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Buffalo"	,/*pos*/new Point2(	810	,	239	),/*reach*/	3	,/*pop100k*/	12	));
        result.add(new City(/*name*/	"Burlington"	,/*pos*/new Point2(	866	,	224	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Calgary"	,/*pos*/new Point2(	458	,	158	),/*reach*/	3	,/*pop100k*/	14	));
        result.add(new City(/*name*/	"Cape Girardeau"	,/*pos*/new Point2(	703	,	295	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Casper"	,/*pos*/new Point2(	535	,	240	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Charleston, SC"	,/*pos*/new Point2(	799	,	340	),/*reach*/	3	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Charleston, WV"	,/*pos*/new Point2(	782	,	285	),/*reach*/	3	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Charlotte"	,/*pos*/new Point2(	790	,	316	),/*reach*/	4	,/*pop100k*/	25	));
        result.add(new City(/*name*/	"Chattanooga"	,/*pos*/new Point2(	746	,	318	),/*reach*/	3	,/*pop100k*/	9	));
        result.add(new City(/*name*/	"Chicago"	,/*pos*/new Point2(	722	,	250	),/*reach*/	5	,/*pop100k*/	99	));
        result.add(new City(/*name*/	"Cincinnati"	,/*pos*/new Point2(	753	,	277	),/*reach*/	4	,/*pop100k*/	22	));
        result.add(new City(/*name*/	"Cleveland"	,/*pos*/new Point2(	782	,	254	),/*reach*/	4	,/*pop100k*/	35	));
        result.add(new City(/*name*/	"Columbia, MO"	,/*pos*/new Point2(	675	,	279	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Columbia, SC"	,/*pos*/new Point2(	789	,	328	),/*reach*/	3	,/*pop100k*/	9	));
        result.add(new City(/*name*/	"Columbus, GA"	,/*pos*/new Point2(	750	,	343	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Columbus, OH"	,/*pos*/new Point2(	769	,	269	),/*reach*/	4	,/*pop100k*/	24	));
        result.add(new City(/*name*/	"Corpus Christi"	,/*pos*/new Point2(	627	,	391	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Colorado Springs"	,/*pos*/new Point2(	551	,	280	),/*reach*/	3	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Dallas-Ft. Worth"	,/*pos*/new Point2(	627	,	341	),/*reach*/	5	,/*pop100k*/	74	));
        result.add(new City(/*name*/	"Davenport"	,/*pos*/new Point2(	692	,	253	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Dayton"	,/*pos*/new Point2(	756	,	271	),/*reach*/	3	,/*pop100k*/	11	));
        result.add(new City(/*name*/	"DC-Baltimore"	,/*pos*/new Point2(	830	,	277	),/*reach*/	5	,/*pop100k*/	95	));
        result.add(new City(/*name*/	"Denver"	,/*pos*/new Point2(	550	,	271	),/*reach*/	4	,/*pop100k*/	33	));
        result.add(new City(/*name*/	"Des Moines"	,/*pos*/new Point2(	662	,	253	),/*reach*/	3	,/*pop100k*/	8	));
        result.add(new City(/*name*/	"Detroit"	,/*pos*/new Point2(	767	,	245	),/*reach*/	5	,/*pop100k*/	53	));
        result.add(new City(/*name*/	"Dodge City"	,/*pos*/new Point2(	598	,	291	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Dothan"	,/*pos*/new Point2(	745	,	356	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Duluth"	,/*pos*/new Point2(	677	,	201	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Edmonton"	,/*pos*/new Point2(	464	,	133	),/*reach*/	3	,/*pop100k*/	13	));
        result.add(new City(/*name*/	"El Paso"	,/*pos*/new Point2(	534	,	350	),/*reach*/	3	,/*pop100k*/	11	));
        result.add(new City(/*name*/	"Erie"	,/*pos*/new Point2(	798	,	247	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Fargo"	,/*pos*/new Point2(	630	,	200	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Flagstaff"	,/*pos*/new Point2(	482	,	316	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Fresno"	,/*pos*/new Point2(	401	,	301	),/*reach*/	3	,/*pop100k*/	11	));
        result.add(new City(/*name*/	"Ft Myers"	,/*pos*/new Point2(	778	,	402	),/*reach*/	3	,/*pop100k*/	10	));
        result.add(new City(/*name*/	"Ft. Wayne"	,/*pos*/new Point2(	747	,	257	),/*reach*/	3	,/*pop100k*/	6	));
        result.add(new City(/*name*/	"Gainesville"	,/*pos*/new Point2(	775	,	372	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Grand Island"	,/*pos*/new Point2(	615	,	259	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Grand Rapids"	,/*pos*/new Point2(	742	,	239	),/*reach*/	3	,/*pop100k*/	14	));
        result.add(new City(/*name*/	"Green Bay"	,/*pos*/new Point2(	719	,	223	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Greenville, NC"	,/*pos*/new Point2(	825	,	312	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Halifax"	,/*pos*/new Point2(	963	,	222	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Harrisburg"	,/*pos*/new Point2(	830	,	266	),/*reach*/	3	,/*pop100k*/	12	));
        result.add(new City(/*name*/	"Hartford"	,/*pos*/new Point2(	872	,	251	),/*reach*/	3	,/*pop100k*/	15	));
        result.add(new City(/*name*/	"Hattiesburg"	,/*pos*/new Point2(	705	,	355	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Honolulu"	,/*pos*/new Point2(	20	,	455	),/*reach*/	3	,/*pop100k*/	10	));
        result.add(new City(/*name*/	"Houston"	,/*pos*/new Point2(	645	,	371	),/*reach*/	5	,/*pop100k*/	67	));
        result.add(new City(/*name*/	"Huntsville"	,/*pos*/new Point2(	733	,	321	),/*reach*/	3	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Indianapolis"	,/*pos*/new Point2(	737	,	271	),/*reach*/	4	,/*pop100k*/	24	));
        result.add(new City(/*name*/	"Jackson"	,/*pos*/new Point2(	696	,	345	),/*reach*/	3	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Jacksonville"	,/*pos*/new Point2(	782	,	365	),/*reach*/	3	,/*pop100k*/	15	));
        result.add(new City(/*name*/	"Kalamazoo"	,/*pos*/new Point2(	743	,	245	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Kansas City"	,/*pos*/new Point2(	653	,	277	),/*reach*/	4	,/*pop100k*/	24	));
        result.add(new City(/*name*/	"Kelowna"	,/*pos*/new Point2(	404	,	170	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Kennewick"	,/*pos*/new Point2(	407	,	206	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Kingsport"	,/*pos*/new Point2(	774	,	304	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Kingston"	,/*pos*/new Point2(	834	,	226	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Kitchener"	,/*pos*/new Point2(	794	,	234	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Knoxville"	,/*pos*/new Point2(	759	,	309	),/*reach*/	3	,/*pop100k*/	11	));
        result.add(new City(/*name*/	"Lansing"	,/*pos*/new Point2(	753	,	241	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Lethbridge"	,/*pos*/new Point2(	470	,	171	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Lexington"	,/*pos*/new Point2(	754	,	288	),/*reach*/	3	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Little Rock"	,/*pos*/new Point2(	675	,	321	),/*reach*/	3	,/*pop100k*/	9	));
        result.add(new City(/*name*/	"London"	,/*pos*/new Point2(	786	,	238	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Los Angeles"	,/*pos*/new Point2(	414	,	328	),/*reach*/	6	,/*pop100k*/	185	));
        result.add(new City(/*name*/	"Louisville"	,/*pos*/new Point2(	742	,	287	),/*reach*/	3	,/*pop100k*/	15	));
        result.add(new City(/*name*/	"Lubbock"	,/*pos*/new Point2(	580	,	333	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Macon"	,/*pos*/new Point2(	764	,	343	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Madison"	,/*pos*/new Point2(	704	,	238	),/*reach*/	3	,/*pop100k*/	8	));
        result.add(new City(/*name*/	"Manchester"	,/*pos*/new Point2(	884	,	239	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"McAllen"	,/*pos*/new Point2(	616	,	406	),/*reach*/	3	,/*pop100k*/	9	));
        result.add(new City(/*name*/	"Memphis"	,/*pos*/new Point2(	699	,	317	),/*reach*/	3	,/*pop100k*/	14	));
        result.add(new City(/*name*/	"Miami"	,/*pos*/new Point2(	796	,	411	),/*reach*/	5	,/*pop100k*/	67	));
        result.add(new City(/*name*/	"Midland"	,/*pos*/new Point2(	577	,	348	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Milwaukee"	,/*pos*/new Point2(	719	,	238	),/*reach*/	4	,/*pop100k*/	20	));
        result.add(new City(/*name*/	"Modesto"	,/*pos*/new Point2(	389	,	292	),/*reach*/	3	,/*pop100k*/	8	));
        result.add(new City(/*name*/	"Montgomery"	,/*pos*/new Point2(	736	,	345	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Montreal"	,/*pos*/new Point2(	863	,	213	),/*reach*/	4	,/*pop100k*/	41	));
        result.add(new City(/*name*/	"MPGB"	,/*pos*/new Point2(	717	,	362	),/*reach*/	3	,/*pop100k*/	14	));
        result.add(new City(/*name*/	"Myrtle Beach"	,/*pos*/new Point2(	810	,	331	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Nashville"	,/*pos*/new Point2(	731	,	307	),/*reach*/	4	,/*pop100k*/	19	));
        result.add(new City(/*name*/	"NC Triad"	,/*pos*/new Point2(	798	,	308	),/*reach*/	4	,/*pop100k*/	16	));
        result.add(new City(/*name*/	"NC Triangle"	,/*pos*/new Point2(	811	,	310	),/*reach*/	4	,/*pop100k*/	20	));
        result.add(new City(/*name*/	"New Orleans"	,/*pos*/new Point2(	699	,	368	),/*reach*/	3	,/*pop100k*/	15	));
        result.add(new City(/*name*/	"New York"	,/*pos*/new Point2(	859	,	262	),/*reach*/	6	,/*pop100k*/	236	));
        result.add(new City(/*name*/	"North Platte"	,/*pos*/new Point2(	591	,	257	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Oklahoma City"	,/*pos*/new Point2(	623	,	314	),/*reach*/	3	,/*pop100k*/	14	));
        result.add(new City(/*name*/	"Omaha-Lincoln"	,/*pos*/new Point2(	635	,	258	),/*reach*/	3	,/*pop100k*/	13	));
        result.add(new City(/*name*/	"Orlando"	,/*pos*/new Point2(	785	,	384	),/*reach*/	4	,/*pop100k*/	31	));
        result.add(new City(/*name*/	"Ottawa"	,/*pos*/new Point2(	841	,	214	),/*reach*/	3	,/*pop100k*/	13	));
        result.add(new City(/*name*/	"Peterborough"	,/*pos*/new Point2(	815	,	225	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Philadelphia"	,/*pos*/new Point2(	847	,	268	),/*reach*/	5	,/*pop100k*/	67	));
        result.add(new City(/*name*/	"Phoenix"	,/*pos*/new Point2(	478	,	333	),/*reach*/	4	,/*pop100k*/	45	));
        result.add(new City(/*name*/	"Pittsburgh"	,/*pos*/new Point2(	799	,	264	),/*reach*/	4	,/*pop100k*/	27	));
        result.add(new City(/*name*/	"Ponce"	,/*pos*/new Point2(	932	,	488	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Portland, OR"	,/*pos*/new Point2(	372	,	213	),/*reach*/	4	,/*pop100k*/	31	));
        result.add(new City(/*name*/	"Portland, ME"	,/*pos*/new Point2(	896	,	232	),/*reach*/	3	,/*pop100k*/	6	));
        result.add(new City(/*name*/	"Prince George"	,/*pos*/new Point2(	371	,	129	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Providence"	,/*pos*/new Point2(	884	,	250	),/*reach*/	4	,/*pop100k*/	16	));
        result.add(new City(/*name*/	"Pueblo"	,/*pos*/new Point2(	552	,	286	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Quebec City"	,/*pos*/new Point2(	886	,	200	),/*reach*/	3	,/*pop100k*/	8	));
        result.add(new City(/*name*/	"Rapid City"	,/*pos*/new Point2(	566	,	228	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Regina"	,/*pos*/new Point2(	552	,	164	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Reno"	,/*pos*/new Point2(	401	,	274	),/*reach*/	3	,/*pop100k*/	6	));
        result.add(new City(/*name*/	"Richmond"	,/*pos*/new Point2(	824	,	293	),/*reach*/	3	,/*pop100k*/	13	));
        result.add(new City(/*name*/	"Roanoke"	,/*pos*/new Point2(	799	,	296	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Rochester"	,/*pos*/new Point2(	822	,	237	),/*reach*/	3	,/*pop100k*/	12	));
        result.add(new City(/*name*/	"Roswell"	,/*pos*/new Point2(	553	,	334	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Sacramento"	,/*pos*/new Point2(	384	,	283	),/*reach*/	4	,/*pop100k*/	25	));
        result.add(new City(/*name*/	"Saginaw"	,/*pos*/new Point2(	759	,	234	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Saguenay"	,/*pos*/new Point2(	888	,	184	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Saint John"	,/*pos*/new Point2(	938	,	216	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Salinas"	,/*pos*/new Point2(	382	,	301	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Salisbury"	,/*pos*/new Point2(	842	,	285	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Salt Lake"	,/*pos*/new Point2(	479	,	261	),/*reach*/	4	,/*pop100k*/	24	));
        result.add(new City(/*name*/	"San Angelo"	,/*pos*/new Point2(	594	,	354	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"San Antonio"	,/*pos*/new Point2(	613	,	374	),/*reach*/	4	,/*pop100k*/	23	));
        result.add(new City(/*name*/	"San Diego"	,/*pos*/new Point2(	427	,	340	),/*reach*/	4	,/*pop100k*/	33	));
        result.add(new City(/*name*/	"San Juan"	,/*pos*/new Point2(	937	,	484	),/*reach*/	4	,/*pop100k*/	25	));
        result.add(new City(/*name*/	"San Luis Obispo"	,/*pos*/new Point2(	392	,	316	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Santa Barbara"	,/*pos*/new Point2(	401	,	324	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Santa Cruz"	,/*pos*/new Point2(	378	,	299	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Saskatoon"	,/*pos*/new Point2(	532	,	147	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Savannah"	,/*pos*/new Point2(	787	,	348	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Seattle"	,/*pos*/new Point2(	375	,	192	),/*reach*/	4	,/*pop100k*/	45	));
        result.add(new City(/*name*/	"Sherbrooke"	,/*pos*/new Point2(	880	,	214	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Shreveport"	,/*pos*/new Point2(	661	,	344	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Sioux Falls"	,/*pos*/new Point2(	631	,	233	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"South Bend"	,/*pos*/new Point2(	736	,	252	),/*reach*/	3	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Space Coast"	,/*pos*/new Point2(	792	,	387	),/*reach*/	3	,/*pop100k*/	6	));
        result.add(new City(/*name*/	"Spokane"	,/*pos*/new Point2(	424	,	192	),/*reach*/	3	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Springfield, MA"	,/*pos*/new Point2(	873	,	247	),/*reach*/	3	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Springfield, MO"	,/*pos*/new Point2(	666	,	296	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"St. George"	,/*pos*/new Point2(	463	,	297	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"St. John's"	,/*pos*/new Point2(	1071	,	193	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"St. Louis"	,/*pos*/new Point2(	696	,	282	),/*reach*/	4	,/*pop100k*/	29	));
        result.add(new City(/*name*/	"Sudbury"	,/*pos*/new Point2(	789	,	203	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Syracuse"	,/*pos*/new Point2(	837	,	238	),/*reach*/	3	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Tallahassee"	,/*pos*/new Point2(	756	,	364	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Tampa Bay"	,/*pos*/new Point2(	773	,	391	),/*reach*/	4	,/*pop100k*/	39	));
        result.add(new City(/*name*/	"Texarkana"	,/*pos*/new Point2(	658	,	334	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Thunder Bay"	,/*pos*/new Point2(	706	,	184	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Tidewater"	,/*pos*/new Point2(	837	,	300	),/*reach*/	4	,/*pop100k*/	18	));
        result.add(new City(/*name*/	"Toledo"	,/*pos*/new Point2(	763	,	252	),/*reach*/	3	,/*pop100k*/	6	));
        result.add(new City(/*name*/	"Toronto-Hamilton"	,/*pos*/new Point2(	805	,	232	),/*reach*/	5	,/*pop100k*/	67	));
        result.add(new City(/*name*/	"Tucson"	,/*pos*/new Point2(	490	,	347	),/*reach*/	3	,/*pop100k*/	11	));
        result.add(new City(/*name*/	"Tulsa"	,/*pos*/new Point2(	639	,	307	),/*reach*/	3	,/*pop100k*/	11	));
        result.add(new City(/*name*/	"Tupelo"	,/*pos*/new Point2(	711	,	326	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Twin Cities"	,/*pos*/new Point2(	667	,	219	),/*reach*/	4	,/*pop100k*/	38	));
        result.add(new City(/*name*/	"Tyler"	,/*pos*/new Point2(	645	,	345	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Upstate SC"	,/*pos*/new Point2(	777	,	320	),/*reach*/	3	,/*pop100k*/	14	));
        result.add(new City(/*name*/	"Valdosta"	,/*pos*/new Point2(	766	,	360	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Vancouver, BC"	,/*pos*/new Point2(	367	,	176	),/*reach*/	4	,/*pop100k*/	26	));
        result.add(new City(/*name*/	"Vegas"	,/*pos*/new Point2(	446	,	306	),/*reach*/	4	,/*pop100k*/	23	));
        result.add(new City(/*name*/	"Victoria"	,/*pos*/new Point2(	628	,	380	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Visalia"	,/*pos*/new Point2(	405	,	305	),/*reach*/	3	,/*pop100k*/	6	));
        result.add(new City(/*name*/	"Waco"	,/*pos*/new Point2(	627	,	353	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Wichita"	,/*pos*/new Point2(	625	,	291	),/*reach*/	3	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Winnipeg"	,/*pos*/new Point2(	627	,	169	),/*reach*/	3	,/*pop100k*/	8	));
        result.add(new City(/*name*/	"Wyo Valley"	,/*pos*/new Point2(	841	,	255	),/*reach*/	3	,/*pop100k*/	6	));
        result.add(new City(/*name*/	"Yakima"	,/*pos*/new Point2(	393	,	202	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Yuma"	,/*pos*/new Point2(	452	,	341	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Missoula"	,/*pos*/new Point2(	458	,	200	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Great Falls"	,/*pos*/new Point2(	486	,	193	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Butte"	,/*pos*/new Point2(	473	,	208	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Bozeman"	,/*pos*/new Point2(	488	,	212	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Idaho Falls"	,/*pos*/new Point2(	478	,	233	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Topeka"	,/*pos*/new Point2(	642	,	278	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Twin Falls"	,/*pos*/new Point2(	454	,	243	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Eugene"	,/*pos*/new Point2(	368	,	228	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Redding"	,/*pos*/new Point2(	375	,	263	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Elko"	,/*pos*/new Point2(	441	,	260	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Farmington, NM"	,/*pos*/new Point2(	516	,	301	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Grand Junction"	,/*pos*/new Point2(	513	,	278	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Fairbanks"	,/*pos*/new Point2(	121	,	20	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Juneau"	,/*pos*/new Point2(	254	,	85	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Terrace"	,/*pos*/new Point2(	312	,	123	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Sydney, NS"	,/*pos*/new Point2(	997	,	207	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Peoria"	,/*pos*/new Point2(	703	,	261	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Rockford"	,/*pos*/new Point2(	708	,	246	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Springfield, IL"	,/*pos*/new Point2(	702	,	271	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Champaign-Urbana"	,/*pos*/new Point2(	716	,	267	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Bloomington, IL"	,/*pos*/new Point2(	709	,	264	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Cheyenne"	,/*pos*/new Point2(	550	,	257	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Lancaster, PA"	,/*pos*/new Point2(	835	,	268	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Fayetteville, AR"	,/*pos*/new Point2(	657	,	308	),/*reach*/	3	,/*pop100k*/	6	));
        result.add(new City(/*name*/	"Cedar Rapids, IA"	,/*pos*/new Point2(	682	,	249	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Kileen"	,/*pos*/new Point2(	621	,	357	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Hickory, NC"	,/*pos*/new Point2(	785	,	311	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Appleton-Oshkosh"	,/*pos*/new Point2(	713	,	227	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Clarksville"	,/*pos*/new Point2(	725	,	303	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Wausau"	,/*pos*/new Point2(	702	,	219	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Medford, OR"	,/*pos*/new Point2(	370	,	245	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Utica-Rome"	,/*pos*/new Point2(	845	,	237	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Longview"	,/*pos*/new Point2(	651	,	343	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Fort Smith"	,/*pos*/new Point2(	654	,	315	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Wilmington, NC"	,/*pos*/new Point2(	819	,	326	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Laredo"	,/*pos*/new Point2(	604	,	393	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Bloomsburg"	,/*pos*/new Point2(	834	,	258	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"PCDFWB"	,/*pos*/new Point2(	738	,	365	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Rocky Mount"	,/*pos*/new Point2(	821	,	309	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Lynchburg, VA"	,/*pos*/new Point2(	807	,	294	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Monroe, LA"	,/*pos*/new Point2(	677	,	343	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Rochester, MN"	,/*pos*/new Point2(	674	,	228	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Harrisonburg"	,/*pos*/new Point2(	810	,	284	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Binghamton"	,/*pos*/new Point2(	839	,	247	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Lafayette, LA"	,/*pos*/new Point2(	678	,	366	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"College Station"	,/*pos*/new Point2(	635	,	362	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Tuscaloosa"	,/*pos*/new Point2(	723	,	336	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Charlottesville"	,/*pos*/new Point2(	814	,	288	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Chico"	,/*pos*/new Point2(	380	,	271	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Lima"	,/*pos*/new Point2(	757	,	261	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Bowling Green, KY"	,/*pos*/new Point2(	734	,	299	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Prescott"	,/*pos*/new Point2(	474	,	323	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Claremont, NH"	,/*pos*/new Point2(	875	,	235	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Mansfield, OH"	,/*pos*/new Point2(	773	,	261	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Johnstown, PA"	,/*pos*/new Point2(	809	,	265	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Houma-Thibodaux"	,/*pos*/new Point2(	691	,	371	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Bloomington, IN"	,/*pos*/new Point2(	733	,	277	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Eau Claire"	,/*pos*/new Point2(	735	,	249	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Bellingham"	,/*pos*/new Point2(	374	,	181	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Joplin"	,/*pos*/new Point2(	653	,	298	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Florence, SC"	,/*pos*/new Point2(	801	,	326	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Lake Charles"	,/*pos*/new Point2(	666	,	366	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Yuma"	,/*pos*/new Point2(	452	,	341	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Hilton Head Island"	,/*pos*/new Point2(	791	,	346	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"New Bern"	,/*pos*/new Point2(	828	,	317	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Hilo"	,/*pos*/new Point2(	48	,	471	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Morgantown"	,/*pos*/new Point2(	799	,	272	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Bend"	,/*pos*/new Point2(	385	,	228	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Elmira"	,/*pos*/new Point2(	830	,	247	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Blacksburg"	,/*pos*/new Point2(	794	,	296	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"El Centro"	,/*pos*/new Point2(	443	,	340	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Terre Haute"	,/*pos*/new Point2(	724	,	274	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Jonesboro"	,/*pos*/new Point2(	691	,	310	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Waterloo, IA"	,/*pos*/new Point2(	675	,	243	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Kahului"	,/*pos*/new Point2(	34	,	459	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Williamsport"	,/*pos*/new Point2(	828	,	256	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Albany, GA"	,/*pos*/new Point2(	757	,	353	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Ithaca"	,/*pos*/new Point2(	833	,	244	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Parkersburg, WV"	,/*pos*/new Point2(	783	,	276	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Wichita Falls, TX"	,/*pos*/new Point2(	614	,	329	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Shoals"	,/*pos*/new Point2(	722	,	321	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Traverse City"	,/*pos*/new Point2(	742	,	221	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Pottsville"	,/*pos*/new Point2(	836	,	262	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Wheeling"	,/*pos*/new Point2(	791	,	268	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Homosassa Springs"	,/*pos*/new Point2(	773	,	380	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"La Crosse"	,/*pos*/new Point2(	686	,	230	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Paducah"	,/*pos*/new Point2(	712	,	298	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Eureka, KS"	,/*pos*/new Point2(	636	,	290	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Manhattan, KS"	,/*pos*/new Point2(	633	,	277	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Jamestown, NY"	,/*pos*/new Point2(	806	,	247	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Logan"	,/*pos*/new Point2(	480	,	251	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Lawton"	,/*pos*/new Point2(	614	,	322	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Findlay-Tiffin"	,/*pos*/new Point2(	764	,	258	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Hot Springs"	,/*pos*/new Point2(	668	,	323	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Jackson, TN"	,/*pos*/new Point2(	710	,	312	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Pittsfield, MA"	,/*pos*/new Point2(	866	,	244	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Edwards, CO"	,/*pos*/new Point2(	533	,	272	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Sierra Vista"	,/*pos*/new Point2(	496	,	353	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"London, KY"	,/*pos*/new Point2(	758	,	297	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Carbondale"	,/*pos*/new Point2(	706	,	291	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Altoona, PA"	,/*pos*/new Point2(	815	,	263	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Goldsboro"	,/*pos*/new Point2(	819	,	315	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Mankato"	,/*pos*/new Point2(	658	,	227	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Beckley"	,/*pos*/new Point2(	787	,	291	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Rome, GA"	,/*pos*/new Point2(	747	,	326	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Victoria, TX"	,/*pos*/new Point2(	628	,	380	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Waterown, NY"	,/*pos*/new Point2(	839	,	229	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Kokomo"	,/*pos*/new Point2(	737	,	264	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Owensboro"	,/*pos*/new Point2(	727	,	291	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Quincy"	,/*pos*/new Point2(	684	,	269	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Wooster, OH"	,/*pos*/new Point2(	779	,	260	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Sheboygan"	,/*pos*/new Point2(	721	,	231	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Brunswick, GA"	,/*pos*/new Point2(	784	,	357	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Wenatchee"	,/*pos*/new Point2(	395	,	194	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Moses Lake"	,/*pos*/new Point2(	406	,	197	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Mount Pleasant, MI"	,/*pos*/new Point2(	751	,	232	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Odgensburg"	,/*pos*/new Point2(	844	,	221	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Decatur, IL"	,/*pos*/new Point2(	709	,	270	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Show Low"	,/*pos*/new Point2(	498	,	326	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Sumter"	,/*pos*/new Point2(	795	,	329	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Cookeville"	,/*pos*/new Point2(	743	,	307	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Roseburg"	,/*pos*/new Point2(	365	,	236	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Meridian, MS"	,/*pos*/new Point2(	711	,	345	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Bluefield"	,/*pos*/new Point2(	786	,	296	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Danville, VA"	,/*pos*/new Point2(	805	,	303	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Grand Forks"	,/*pos*/new Point2(	628	,	189	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Fond Du Lac"	,/*pos*/new Point2(	714	,	231	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Tullahoma"	,/*pos*/new Point2(	736	,	315	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Cumberland, MD"	,/*pos*/new Point2(	811	,	272	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Sebring, FL"	,/*pos*/new Point2(	784	,	393	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Dubuque"	,/*pos*/new Point2(	692	,	243	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Kalispell"	,/*pos*/new Point2(	455	,	186	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Clarksburg, WV"	,/*pos*/new Point2(	795	,	276	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Pinehurst"	,/*pos*/new Point2(	804	,	316	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Brainerd"	,/*pos*/new Point2(	656	,	205	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Red Deer"	,/*pos*/new Point2(	460	,	146	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Nanaimo, BC"	,/*pos*/new Point2(	359	,	177	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Kamloops"	,/*pos*/new Point2(	395	,	162	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Trois-Rivieres"	,/*pos*/new Point2(	873	,	205	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Guelph"	,/*pos*/new Point2(	796	,	233	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Belleville"	,/*pos*/new Point2(	825	,	227	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Chatham-Kent"	,/*pos*/new Point2(	777	,	244	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Fredericton"	,/*pos*/new Point2(	932	,	209	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Chilliwack"	,/*pos*/new Point2(	379	,	177	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Sarnia"	,/*pos*/new Point2(	774	,	239	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Drummondville"	,/*pos*/new Point2(	874	,	210	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Saul Ste. Marie"	,/*pos*/new Point2(	755	,	203	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Medicine Hat"	,/*pos*/new Point2(	492	,	168	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Moncton"	,/*pos*/new Point2(	951	,	208	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Brantford"	,/*pos*/new Point2(	796	,	237	),/*reach*/	1	,/*pop100k*/	1	));
        
    }
    
    private static void removeSmallAndLargeCities() {
        CityList removeList=new CityList();
        for(City c: result){
            if(c.pop100k<MIN_POP_THRESHOLD||c.pop100k>MAX_POP_THRESHOLD)
                removeList.add(c);
        }
        for(City rc: removeList){
            result.remove(rc);            
        }
    }
    
    private static void sortCitiesByPopulation() {
        result.sortByPopulation();
    }

    public static CityList create(){
        result=new CityList();
        if(SHOULD_ADD_ALL_CITIES)
            addAllCities();        
        else
            addSomeCities();
        if(SHOULD_REMOVE_SMALL_CITIES)
            removeSmallAndLargeCities();
        sortCitiesByPopulation();     
        return result;
    }

}
