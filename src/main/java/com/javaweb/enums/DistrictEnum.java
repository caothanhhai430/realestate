package com.javaweb.enums;

public enum DistrictEnum {
	QUAN_1("Quận 1"),
	QUAN_2("Quận 2"),
	QUAN_3("Quận 3"),
	QUAN_4("Quận 4"),
	QUAN_5("Quận 5"),
	QUAN_6("Quận 6"),
	QUAN_7("Quận 7"),
	QUAN_8("Quận 8"),
	QUAN_9("Quận 9"),
	QUAN_10("Quận 10"),
	QUAN_11("Quận 11"),
	QUAN_12("Quận 12"),
	QUAN_THU_DUC("Quận Thủ Đức"),
	QUAN_GO_VAP("Quận Gò Vấp"),
	QUAN_BINH_THANH("Quận Bình Thạnh"),
	QUAN_TAN_BINH("Quận Tân Bình"),
	QUAN_TAN_PHU("Quận Tân Phú"),
	QUAN_PHU_NHUAN("Quận Phú Nhuận"),
	QUAN_BINH_TAN("Quận Bình Tân"),
	HUYEN_CU_CHI("Huyện Củ Chi"),
	HUYEN_HOC_MON("Huyện Hóc Môn"),
	HUYEN_BINH_CHANH("Huyện Bình Chánh"),
	HUYEN_NHA_BE("Huyện Nhà Bè"),
	HUYEN_CAN_GIO("Huyện Cần Giờ");

	private final String districtName;
	
	DistrictEnum(String districtName){
		this.districtName = districtName;
	}
	
	public String getDistrictName() {
		return this.districtName;
	}
}


