@Override
public Condition parseParamsWebshop(String... params) {

	if (params == null || params.length == 0) {
		return null;
	}

	List<Condition> filterList = new ArrayList<>();

	for (String param : params) {

		String operation = "";
		final Matcher m = Pattern.compile("[:%<>]").matcher(param);
		if (m.find())
			switch (m.group().charAt(0)) {
				case ':' -> operation = ":";
				case '%' -> operation = "%";
				case '<' -> operation = "<";
				case '>' -> operation = ">";
			}
			
		if (operation.isEmpty()) return null;

		String[] split = param.split(operation);
		switch (split[0]) {
			case "handle" -> {
				if (operation.equals(":")) {
					filterList.add(Tables.WEBSHOP.HANDLE.equalIgnoreCase(split[1]));
				} else if (operation.equals("%")) {
					filterList.add(Tables.WEBSHOP.HANDLE.likeIgnoreCase(split[1]));
				}
			}
			case "interestRate" -> {
				if (operation.equals(">")) {
					filterList.add(Tables.WEBSHOP.INTEREST_RATE.greaterThan(Short.parseShort(split[1])));
				} else if (operation.equals("<")) {
					filterList.add(Tables.WEBSHOP.INTEREST_RATE.lessThan(Short.parseShort(split[1])));
				}
			}
			// To add more later
		}
	}

	Condition condition = filterList.get(0);
	filterList.remove(0);
	for (Condition c : filterList) {
		condition = condition.and(c);
	}

	return condition;
}