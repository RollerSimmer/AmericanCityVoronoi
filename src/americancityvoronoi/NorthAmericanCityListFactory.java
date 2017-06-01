/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package americancityvoronoi;

import math.IntVector2;

/**
 *
 * @author rollersimmer
 */
public class NorthAmericanCityListFactory {
    
    public static boolean SHOULD_ADD_ALL_CITIES=true;
    public static boolean SHOULD_REMOVE_SMALL_CITIES=true;
    public static int LARGE_POP_THRESHOLD=3;

    private static CityList result=null;

    private static void addSomeCities() {
        int XOFS=810;
        int YOFS=256;
        result.add(/*name*/new City(	"Albany"	,/*pos*/new IntVector2(	862-XOFS	,	273-YOFS	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(/*name*/new City(	"Buffalo"	,/*pos*/new IntVector2(	811-XOFS	,	271-YOFS	),/*reach*/	4	,/*pop100k*/	12	));
        result.add(/*name*/new City(	"Atl City"	,/*pos*/new IntVector2(	856-XOFS	,	306-YOFS	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(/*name*/new City(	"New York"	,/*pos*/new IntVector2(	861-XOFS	,	293-YOFS	),/*reach*/	16	,/*pop100k*/	236	));
        result.add(/*name*/new City(	"Philadelphia"	,/*pos*/new IntVector2(	849-XOFS	,	300-YOFS	),/*reach*/	9	,/*pop100k*/	67	));
    }


    private static void addAllCities() {
        
        result.add(new City(/*name*/	"Abilene"	,/*pos*/new IntVector2(	675	,	319	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Albany"	,/*pos*/new IntVector2(	934	,	217	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Albuquerque"	,/*pos*/new IntVector2(	606	,	293	),/*reach*/	3	,/*pop100k*/	12	));
        result.add(new City(/*name*/	"Alexandria, LA"	,/*pos*/new IntVector2(	747	,	331	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Amarillo"	,/*pos*/new IntVector2(	654	,	292	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Anchorage"	,/*pos*/new IntVector2(	173	,	32	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Anniston-Gadsden"	,/*pos*/new IntVector2(	813	,	306	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Atlanta"	,/*pos*/new IntVector2(	828	,	306	),/*reach*/	4	,/*pop100k*/	62	));
        result.add(new City(/*name*/	"Atlantic City"	,/*pos*/new IntVector2(	928	,	250	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Augusta, GA"	,/*pos*/new IntVector2(	851	,	310	),/*reach*/	2	,/*pop100k*/	6	));
        result.add(new City(/*name*/	"Augusta, ME"	,/*pos*/new IntVector2(	974	,	201	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Austin"	,/*pos*/new IntVector2(	694	,	341	),/*reach*/	3	,/*pop100k*/	19	));
        result.add(new City(/*name*/	"Bakersfield"	,/*pos*/new IntVector2(	482	,	291	),/*reach*/	3	,/*pop100k*/	9	));
        result.add(new City(/*name*/	"Bangor"	,/*pos*/new IntVector2(	984	,	196	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Barrie"	,/*pos*/new IntVector2(	875	,	200	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Baton Rouge"	,/*pos*/new IntVector2(	761	,	340	),/*reach*/	2	,/*pop100k*/	8	));
        result.add(new City(/*name*/	"Battle Creek"	,/*pos*/new IntVector2(	820	,	221	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Bay Area"	,/*pos*/new IntVector2(	448	,	266	),/*reach*/	5	,/*pop100k*/	83	));
        result.add(new City(/*name*/	"Billings"	,/*pos*/new IntVector2(	587	,	186	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Birmingham"	,/*pos*/new IntVector2(	804	,	309	),/*reach*/	3	,/*pop100k*/	13	));
        result.add(new City(/*name*/	"Bismark"	,/*pos*/new IntVector2(	664	,	176	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Boise"	,/*pos*/new IntVector2(	510	,	208	),/*reach*/	2	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Boston"	,/*pos*/new IntVector2(	962	,	221	),/*reach*/	5	,/*pop100k*/	75	));
        result.add(new City(/*name*/	"Brownsville"	,/*pos*/new IntVector2(	697	,	384	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Buffalo"	,/*pos*/new IntVector2(	883	,	215	),/*reach*/	3	,/*pop100k*/	12	));
        result.add(new City(/*name*/	"Burlington"	,/*pos*/new IntVector2(	940	,	199	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Calgary"	,/*pos*/new IntVector2(	531	,	134	),/*reach*/	3	,/*pop100k*/	14	));
        result.add(new City(/*name*/	"Cape Girardeau"	,/*pos*/new IntVector2(	777	,	271	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Casper"	,/*pos*/new IntVector2(	609	,	216	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Charleston, SC"	,/*pos*/new IntVector2(	872	,	316	),/*reach*/	2	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Charleston, WV"	,/*pos*/new IntVector2(	856	,	261	),/*reach*/	2	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Charlotte"	,/*pos*/new IntVector2(	864	,	292	),/*reach*/	3	,/*pop100k*/	25	));
        result.add(new City(/*name*/	"Chattanooga"	,/*pos*/new IntVector2(	820	,	293	),/*reach*/	3	,/*pop100k*/	9	));
        result.add(new City(/*name*/	"Chicago"	,/*pos*/new IntVector2(	795	,	226	),/*reach*/	5	,/*pop100k*/	99	));
        result.add(new City(/*name*/	"Cincinnati"	,/*pos*/new IntVector2(	827	,	253	),/*reach*/	3	,/*pop100k*/	22	));
        result.add(new City(/*name*/	"Cleveland"	,/*pos*/new IntVector2(	855	,	229	),/*reach*/	4	,/*pop100k*/	35	));
        result.add(new City(/*name*/	"Columbia, MO"	,/*pos*/new IntVector2(	749	,	255	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Columbia, SC"	,/*pos*/new IntVector2(	863	,	304	),/*reach*/	3	,/*pop100k*/	9	));
        result.add(new City(/*name*/	"Columbus, GA"	,/*pos*/new IntVector2(	823	,	319	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Columbus, OH"	,/*pos*/new IntVector2(	842	,	244	),/*reach*/	3	,/*pop100k*/	24	));
        result.add(new City(/*name*/	"Corpus Christi"	,/*pos*/new IntVector2(	700	,	366	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Colorado Springs"	,/*pos*/new IntVector2(	624	,	255	),/*reach*/	2	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Dallas-Ft. Worth"	,/*pos*/new IntVector2(	701	,	317	),/*reach*/	5	,/*pop100k*/	74	));
        result.add(new City(/*name*/	"Davenport"	,/*pos*/new IntVector2(	766	,	228	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Dayton"	,/*pos*/new IntVector2(	830	,	246	),/*reach*/	3	,/*pop100k*/	11	));
        result.add(new City(/*name*/	"DC-Baltimore"	,/*pos*/new IntVector2(	904	,	253	),/*reach*/	5	,/*pop100k*/	95	));
        result.add(new City(/*name*/	"Denver"	,/*pos*/new IntVector2(	623	,	246	),/*reach*/	4	,/*pop100k*/	33	));
        result.add(new City(/*name*/	"Des Moines"	,/*pos*/new IntVector2(	736	,	228	),/*reach*/	2	,/*pop100k*/	8	));
        result.add(new City(/*name*/	"Detroit"	,/*pos*/new IntVector2(	841	,	220	),/*reach*/	4	,/*pop100k*/	53	));
        result.add(new City(/*name*/	"Dodge City"	,/*pos*/new IntVector2(	672	,	267	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Dothan"	,/*pos*/new IntVector2(	818	,	332	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Duluth"	,/*pos*/new IntVector2(	751	,	176	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Edmonton"	,/*pos*/new IntVector2(	537	,	109	),/*reach*/	3	,/*pop100k*/	13	));
        result.add(new City(/*name*/	"El Paso"	,/*pos*/new IntVector2(	608	,	326	),/*reach*/	3	,/*pop100k*/	11	));
        result.add(new City(/*name*/	"Erie"	,/*pos*/new IntVector2(	871	,	223	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Fargo"	,/*pos*/new IntVector2(	704	,	175	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Flagstaff"	,/*pos*/new IntVector2(	556	,	292	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Fresno"	,/*pos*/new IntVector2(	474	,	276	),/*reach*/	3	,/*pop100k*/	11	));
        result.add(new City(/*name*/	"Ft Myers"	,/*pos*/new IntVector2(	852	,	378	),/*reach*/	3	,/*pop100k*/	10	));
        result.add(new City(/*name*/	"Ft. Wayne"	,/*pos*/new IntVector2(	821	,	233	),/*reach*/	2	,/*pop100k*/	6	));
        result.add(new City(/*name*/	"Gainesville"	,/*pos*/new IntVector2(	849	,	347	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Grand Island"	,/*pos*/new IntVector2(	688	,	235	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Grand Rapids"	,/*pos*/new IntVector2(	815	,	214	),/*reach*/	3	,/*pop100k*/	14	));
        result.add(new City(/*name*/	"Green Bay"	,/*pos*/new IntVector2(	792	,	199	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Greenville, NC"	,/*pos*/new IntVector2(	898	,	288	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Halifax"	,/*pos*/new IntVector2(	1036	,	198	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Harrisburg"	,/*pos*/new IntVector2(	903	,	241	),/*reach*/	3	,/*pop100k*/	12	));
        result.add(new City(/*name*/	"Hartford"	,/*pos*/new IntVector2(	945	,	226	),/*reach*/	3	,/*pop100k*/	15	));
        result.add(new City(/*name*/	"Hattiesburg"	,/*pos*/new IntVector2(	779	,	331	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Honolulu"	,/*pos*/new IntVector2(	94	,	431	),/*reach*/	3	,/*pop100k*/	10	));
        result.add(new City(/*name*/	"Houston"	,/*pos*/new IntVector2(	718	,	346	),/*reach*/	5	,/*pop100k*/	67	));
        result.add(new City(/*name*/	"Huntsville"	,/*pos*/new IntVector2(	807	,	296	),/*reach*/	2	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Indianapolis"	,/*pos*/new IntVector2(	811	,	246	),/*reach*/	3	,/*pop100k*/	24	));
        result.add(new City(/*name*/	"Jackson"	,/*pos*/new IntVector2(	770	,	321	),/*reach*/	2	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Jacksonville"	,/*pos*/new IntVector2(	855	,	341	),/*reach*/	3	,/*pop100k*/	15	));
        result.add(new City(/*name*/	"Kalamazoo"	,/*pos*/new IntVector2(	816	,	221	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Kansas City"	,/*pos*/new IntVector2(	726	,	253	),/*reach*/	3	,/*pop100k*/	24	));
        result.add(new City(/*name*/	"Kelowna"	,/*pos*/new IntVector2(	477	,	145	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Kennewick"	,/*pos*/new IntVector2(	481	,	182	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Kingsport"	,/*pos*/new IntVector2(	848	,	280	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Kingston"	,/*pos*/new IntVector2(	907	,	202	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Kitchener"	,/*pos*/new IntVector2(	867	,	209	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Knoxville"	,/*pos*/new IntVector2(	833	,	284	),/*reach*/	3	,/*pop100k*/	11	));
        result.add(new City(/*name*/	"Lansing"	,/*pos*/new IntVector2(	826	,	217	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Lethbridge"	,/*pos*/new IntVector2(	544	,	147	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Lexington"	,/*pos*/new IntVector2(	827	,	264	),/*reach*/	2	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Little Rock"	,/*pos*/new IntVector2(	748	,	297	),/*reach*/	3	,/*pop100k*/	9	));
        result.add(new City(/*name*/	"London"	,/*pos*/new IntVector2(	860	,	214	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Los Angeles"	,/*pos*/new IntVector2(	488	,	304	),/*reach*/	6	,/*pop100k*/	185	));
        result.add(new City(/*name*/	"Louisville"	,/*pos*/new IntVector2(	815	,	262	),/*reach*/	3	,/*pop100k*/	15	));
        result.add(new City(/*name*/	"Lubbock"	,/*pos*/new IntVector2(	653	,	308	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Macon"	,/*pos*/new IntVector2(	838	,	319	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Madison"	,/*pos*/new IntVector2(	778	,	213	),/*reach*/	2	,/*pop100k*/	8	));
        result.add(new City(/*name*/	"Manchester"	,/*pos*/new IntVector2(	958	,	214	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"McAllen"	,/*pos*/new IntVector2(	690	,	382	),/*reach*/	3	,/*pop100k*/	9	));
        result.add(new City(/*name*/	"Memphis"	,/*pos*/new IntVector2(	772	,	293	),/*reach*/	3	,/*pop100k*/	14	));
        result.add(new City(/*name*/	"Miami"	,/*pos*/new IntVector2(	870	,	386	),/*reach*/	5	,/*pop100k*/	67	));
        result.add(new City(/*name*/	"Midland"	,/*pos*/new IntVector2(	651	,	324	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Milwaukee"	,/*pos*/new IntVector2(	792	,	213	),/*reach*/	3	,/*pop100k*/	20	));
        result.add(new City(/*name*/	"Modesto"	,/*pos*/new IntVector2(	462	,	267	),/*reach*/	2	,/*pop100k*/	8	));
        result.add(new City(/*name*/	"Montgomery"	,/*pos*/new IntVector2(	809	,	321	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Montreal"	,/*pos*/new IntVector2(	936	,	189	),/*reach*/	4	,/*pop100k*/	41	));
        result.add(new City(/*name*/	"MPGB"	,/*pos*/new IntVector2(	791	,	337	),/*reach*/	3	,/*pop100k*/	14	));
        result.add(new City(/*name*/	"Myrtle Beach"	,/*pos*/new IntVector2(	883	,	307	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Nashville"	,/*pos*/new IntVector2(	804	,	282	),/*reach*/	3	,/*pop100k*/	19	));
        result.add(new City(/*name*/	"NC Triad"	,/*pos*/new IntVector2(	872	,	284	),/*reach*/	3	,/*pop100k*/	16	));
        result.add(new City(/*name*/	"NC Triangle"	,/*pos*/new IntVector2(	884	,	286	),/*reach*/	3	,/*pop100k*/	20	));
        result.add(new City(/*name*/	"New Orleans"	,/*pos*/new IntVector2(	773	,	343	),/*reach*/	3	,/*pop100k*/	15	));
        result.add(new City(/*name*/	"New York"	,/*pos*/new IntVector2(	933	,	237	),/*reach*/	7	,/*pop100k*/	236	));
        result.add(new City(/*name*/	"North Platte"	,/*pos*/new IntVector2(	664	,	233	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Oklahoma City"	,/*pos*/new IntVector2(	697	,	289	),/*reach*/	3	,/*pop100k*/	14	));
        result.add(new City(/*name*/	"Omaha-Lincoln"	,/*pos*/new IntVector2(	708	,	234	),/*reach*/	3	,/*pop100k*/	13	));
        result.add(new City(/*name*/	"Orlando"	,/*pos*/new IntVector2(	859	,	360	),/*reach*/	4	,/*pop100k*/	31	));
        result.add(new City(/*name*/	"Ottawa"	,/*pos*/new IntVector2(	915	,	190	),/*reach*/	3	,/*pop100k*/	13	));
        result.add(new City(/*name*/	"Peterborough"	,/*pos*/new IntVector2(	889	,	201	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Philadelphia"	,/*pos*/new IntVector2(	921	,	244	),/*reach*/	5	,/*pop100k*/	67	));
        result.add(new City(/*name*/	"Phoenix"	,/*pos*/new IntVector2(	551	,	308	),/*reach*/	4	,/*pop100k*/	45	));
        result.add(new City(/*name*/	"Pittsburgh"	,/*pos*/new IntVector2(	872	,	240	),/*reach*/	3	,/*pop100k*/	27	));
        result.add(new City(/*name*/	"Portland, OR"	,/*pos*/new IntVector2(	446	,	189	),/*reach*/	4	,/*pop100k*/	31	));
        result.add(new City(/*name*/	"Portland, ME"	,/*pos*/new IntVector2(	969	,	207	),/*reach*/	2	,/*pop100k*/	6	));
        result.add(new City(/*name*/	"Prince George"	,/*pos*/new IntVector2(	445	,	105	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Providence"	,/*pos*/new IntVector2(	958	,	226	),/*reach*/	3	,/*pop100k*/	16	));
        result.add(new City(/*name*/	"Pueblo"	,/*pos*/new IntVector2(	626	,	261	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Quebec City"	,/*pos*/new IntVector2(	960	,	176	),/*reach*/	2	,/*pop100k*/	8	));
        result.add(new City(/*name*/	"Rapid City"	,/*pos*/new IntVector2(	640	,	203	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Regina"	,/*pos*/new IntVector2(	626	,	140	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Reno"	,/*pos*/new IntVector2(	474	,	249	),/*reach*/	2	,/*pop100k*/	6	));
        result.add(new City(/*name*/	"Richmond"	,/*pos*/new IntVector2(	897	,	269	),/*reach*/	3	,/*pop100k*/	13	));
        result.add(new City(/*name*/	"Roanoke"	,/*pos*/new IntVector2(	873	,	271	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Rochester"	,/*pos*/new IntVector2(	896	,	212	),/*reach*/	3	,/*pop100k*/	12	));
        result.add(new City(/*name*/	"Roswell"	,/*pos*/new IntVector2(	627	,	310	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Sacramento"	,/*pos*/new IntVector2(	457	,	258	),/*reach*/	3	,/*pop100k*/	25	));
        result.add(new City(/*name*/	"Saginaw"	,/*pos*/new IntVector2(	832	,	210	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Saguenay"	,/*pos*/new IntVector2(	961	,	160	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Saint John"	,/*pos*/new IntVector2(	1011	,	191	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Salinas"	,/*pos*/new IntVector2(	456	,	277	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Salisbury"	,/*pos*/new IntVector2(	916	,	260	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Salt Lake"	,/*pos*/new IntVector2(	553	,	236	),/*reach*/	3	,/*pop100k*/	24	));
        result.add(new City(/*name*/	"San Angelo"	,/*pos*/new IntVector2(	668	,	330	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"San Antonio"	,/*pos*/new IntVector2(	687	,	349	),/*reach*/	3	,/*pop100k*/	23	));
        result.add(new City(/*name*/	"San Diego"	,/*pos*/new IntVector2(	501	,	316	),/*reach*/	4	,/*pop100k*/	33	));
        result.add(new City(/*name*/	"San Luis Obispo"	,/*pos*/new IntVector2(	465	,	291	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Santa Barbara"	,/*pos*/new IntVector2(	475	,	300	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Santa Cruz"	,/*pos*/new IntVector2(	452	,	274	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Saskatoon"	,/*pos*/new IntVector2(	605	,	123	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Savannah"	,/*pos*/new IntVector2(	860	,	324	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Seattle"	,/*pos*/new IntVector2(	448	,	168	),/*reach*/	4	,/*pop100k*/	45	));
        result.add(new City(/*name*/	"Sherbrooke"	,/*pos*/new IntVector2(	953	,	190	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Shreveport"	,/*pos*/new IntVector2(	734	,	319	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"Sioux Falls"	,/*pos*/new IntVector2(	705	,	209	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"South Bend"	,/*pos*/new IntVector2(	809	,	227	),/*reach*/	2	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Space Coast"	,/*pos*/new IntVector2(	866	,	363	),/*reach*/	2	,/*pop100k*/	6	));
        result.add(new City(/*name*/	"Spokane"	,/*pos*/new IntVector2(	498	,	167	),/*reach*/	2	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Springfield, MA"	,/*pos*/new IntVector2(	947	,	223	),/*reach*/	2	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Springfield, MO"	,/*pos*/new IntVector2(	739	,	272	),/*reach*/	2	,/*pop100k*/	5	));
        result.add(new City(/*name*/	"St. George"	,/*pos*/new IntVector2(	536	,	273	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"St. John's"	,/*pos*/new IntVector2(	1145	,	168	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"St. Louis"	,/*pos*/new IntVector2(	770	,	258	),/*reach*/	4	,/*pop100k*/	29	));
        result.add(new City(/*name*/	"Sudbury"	,/*pos*/new IntVector2(	862	,	179	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Syracuse"	,/*pos*/new IntVector2(	911	,	214	),/*reach*/	2	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Tallahassee"	,/*pos*/new IntVector2(	829	,	339	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Tampa Bay"	,/*pos*/new IntVector2(	847	,	367	),/*reach*/	4	,/*pop100k*/	39	));
        result.add(new City(/*name*/	"Texarkana"	,/*pos*/new IntVector2(	732	,	310	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Thunder Bay"	,/*pos*/new IntVector2(	780	,	160	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Tidewater"	,/*pos*/new IntVector2(	910	,	276	),/*reach*/	3	,/*pop100k*/	18	));
        result.add(new City(/*name*/	"Toledo"	,/*pos*/new IntVector2(	836	,	227	),/*reach*/	2	,/*pop100k*/	6	));
        result.add(new City(/*name*/	"Toronto-Hamilton"	,/*pos*/new IntVector2(	878	,	208	),/*reach*/	5	,/*pop100k*/	67	));
        result.add(new City(/*name*/	"Tucson"	,/*pos*/new IntVector2(	563	,	322	),/*reach*/	3	,/*pop100k*/	11	));
        result.add(new City(/*name*/	"Tulsa"	,/*pos*/new IntVector2(	713	,	283	),/*reach*/	3	,/*pop100k*/	11	));
        result.add(new City(/*name*/	"Tupelo"	,/*pos*/new IntVector2(	785	,	301	),/*reach*/	1	,/*pop100k*/	1	));
        result.add(new City(/*name*/	"Twin Cities"	,/*pos*/new IntVector2(	740	,	194	),/*reach*/	4	,/*pop100k*/	38	));
        result.add(new City(/*name*/	"Tyler"	,/*pos*/new IntVector2(	719	,	321	),/*reach*/	2	,/*pop100k*/	3	));
        result.add(new City(/*name*/	"Upstate SC"	,/*pos*/new IntVector2(	850	,	295	),/*reach*/	3	,/*pop100k*/	14	));
        result.add(new City(/*name*/	"Valdosta"	,/*pos*/new IntVector2(	839	,	336	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Vancouver, BC"	,/*pos*/new IntVector2(	441	,	151	),/*reach*/	3	,/*pop100k*/	26	));
        result.add(new City(/*name*/	"Vegas"	,/*pos*/new IntVector2(	519	,	282	),/*reach*/	3	,/*pop100k*/	23	));
        result.add(new City(/*name*/	"Victoria"	,/*pos*/new IntVector2(	702	,	356	),/*reach*/	2	,/*pop100k*/	4	));
        result.add(new City(/*name*/	"Visalia"	,/*pos*/new IntVector2(	479	,	281	),/*reach*/	2	,/*pop100k*/	6	));
        result.add(new City(/*name*/	"Wichita"	,/*pos*/new IntVector2(	699	,	267	),/*reach*/	2	,/*pop100k*/	7	));
        result.add(new City(/*name*/	"Winnipeg"	,/*pos*/new IntVector2(	701	,	145	),/*reach*/	2	,/*pop100k*/	8	));
        result.add(new City(/*name*/	"Wyo Valley"	,/*pos*/new IntVector2(	915	,	231	),/*reach*/	2	,/*pop100k*/	6	));
        result.add(new City(/*name*/	"Yakima"	,/*pos*/new IntVector2(	467	,	178	),/*reach*/	2	,/*pop100k*/	2	));
        result.add(new City(/*name*/	"Yuma"	,/*pos*/new IntVector2(	526	,	317	),/*reach*/	2	,/*pop100k*/	2	));

    }
    
    private static void removeSmallCities() {
        CityList removeList=new CityList();
        for(City c: result){
            if(c.pop100k<LARGE_POP_THRESHOLD)
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
            removeSmallCities();
        sortCitiesByPopulation();     
        return result;
    }

}
