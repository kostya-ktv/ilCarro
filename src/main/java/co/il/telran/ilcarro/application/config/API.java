package application.config;

public class API {
	
	// Basic
	
	public static final String SECURITY = "/security";
	
	public static final String ADD_USER = "/addUser";
	public static final String ADD_ACCOUNT = "/addAccount";
	public static final String CREATE_ROLE = "/createRole";
	public static final String GRANT_ROLE = "/grantRole";
	public static final String DEPRIVE_ROLE = "/depriveRole";
	public static final String GET_ALL_ACCOUNTS = "/getAllAccounts";
	public static final String GET_ACCOUNTS_BY_ROLE = "/depriveRole";
	public static final String GET_ALL_ROLES = "/getAllRoles";
	public static final String GET_ROLES_BY_LOGIN = "/getRolesByLogin";
	public static final String REMOVE_ACCOUNT = "/removeAccount";
	public static final String REMOVE_USER = "/removeUser";
	
	// JWT
	
	public static final String JWT = "/jwt";
	
	public static final String AUTHENTICATE = "/authenticate";
			
	// Business
	
	public static final String BUSINESS = "/business";
	
	public static final String ADD_CAR = "/addCar";
	public static final String ADD_RANDOM_CARS = "/addRandomCar";
	public static final String GET_ALL_CARS = "/getAllCars";
	
}
