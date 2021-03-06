@Override
public SortField<?> sortParserWebshop(String sort, String order) {

	if (sort == null || sort.isEmpty()) {
		sort = "handle";
	}

	if (order == null || order.isEmpty()) {
		order = "asc";
	}

	sort = sort.toLowerCase();
	order = order.toLowerCase();

	switch (sort) {
		case "handle" -> {
			if (order.equals("asc")) {
				return Tables.WEBSHOP.HANDLE.asc();
			} else if (order.equals("desc")) {
				return Tables.WEBSHOP.HANDLE.desc();
			}
			return Tables.WEBSHOP.HANDLE.asc();
		}
		
		case "url" -> {
			if (order.equals("asc")) {
				return Tables.WEBSHOP.URL.asc();
			} else if (order.equals("desc")) {
				return Tables.WEBSHOP.URL.desc();
			}
			return Tables.WEBSHOP.URL.asc();
		}
		case "interestrate" -> {
			if (order.equals("asc")) {
				return Tables.WEBSHOP.INTEREST_RATE.asc();
			} else if (order.equals("desc")) {
				return Tables.WEBSHOP.INTEREST_RATE.desc();
			}
			return Tables.WEBSHOP.INTEREST_RATE.asc();
		}
		// To add more later
	}

	return Tables.WEBSHOP.HANDLE.asc();
}