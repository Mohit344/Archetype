package com.website.websiteautomation.dataprovider;





import org.testng.annotations.DataProvider;

import com.website.websiteautomation.constant.FileConstant;
import com.website.websiteautomation.util.ProviderData;

public class DataProviderData {

	
	/**
	 * Data provider 1
	 * @return
	 */
		@DataProvider(name ="positiveScenario" )
		public Object[][] getDataOne() {
			ProviderData provideData = new ProviderData(FileConstant.testdata);
			Object[][] getData = provideData.provideData();
			return getData;
		}
	
		
		/**moreinfotestdata
		 * data provider 2
		 * @return
		 */
//		@DataProvider(name = "negativeScenario")
//		public Object[][] getDataSecond() {
//			ProviderData provideData = new ProviderData(FileConstant.negativeScenario);
//			Object[][] getData = provideData.provideData();
//			return getData;
//		}
//		
//		/**
//		 * Data provider 3
//		 * @return
//		 */
//			@DataProvider(name = "productContent")
//			public Object[][] getDataThird() {
//				ProviderData provideData = new ProviderData(FileConstant.productContent);
//				Object[][] getData = provideData.provideData();
//				return getData;
//			}
//		
//			/**
//			 * Data provider 4
//			 * @return
//			 */
//				@DataProvider(name = "productReview")
//				public Object[][] getDataForth() {
//					ProviderData provideData = new ProviderData(FileConstant.productReview);
//					Object[][] getData = provideData.provideData();
//					return getData;
//				}
//		
//		
		
		
}
