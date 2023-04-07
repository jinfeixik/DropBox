package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

	// ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101300674233";

	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCTuicPzgnBDw5/g/zUFDRIb75/HfZRtrUwXZEWeXNmDIJRY/y4iUHM6SOmaaUESEQCM4LaUUxE1lGUlkApLHwHS3raxzEH5JpUKqUxCDTc8dulkJ3eRe2bgwDmeVAvFI7aTKlmoVv0Y3SsPqHlPELs8kd/rC6Muf2hq8RL3D3QLqkHxmxKoxeZCMarL4zEflzCglzJ28+UzM6TAvD2ajEGRN4WxPlWkglkL3CRK6ehqyAADy7t4xqznmZpJ7N/Yk+KZG8EpG2TStXvHUoFmBO+ODlcU6eXhsNiPnd8Zol0+IPLA6Phzj/4dE2sLU4l2S50fgg/WZ1UgrDLPFR8HivjAgMBAAECggEAWD5ejwZYtUY1Nt607EqVYJ+/f1d6iB1H5ng97trloBPg1JWRpPn4oFqzvPhmZkR0u4vhol/l20jaupN2CCJWhFUGMiHCnCBmP9ipjLyGN2UR+7iDVP8YjEiZBRN6XmU9YBFjL7c7oqS2UR2ov7JbmAaxxwYnWFDRvP1J6LbLBcuxM3SItY5b2nJFg1E0sDq2Sm5hehVJ6XVVjqFF9jTRszMElTrCyBlv9S6lYLKUixjgUiuPyL92KLnMKHzqD1RyO3miQB5R7MPfpZfb+MQd7FqbaXczzqbp2yk1SbhAFhhDYigN3D6g2AHQqGehXDonmLdeauxASpTPioas/4B9gQKBgQDGcoI4pIiUpWYFo/sC4Cp42SgH2ola/wMUChRHhKpkEQ05VtKDFuThUxlyXcWKZDGcuco97UFa2uSjoN7hjMc3PtcGe73b2nubOed6fTFuf7AswT+D+mYmfqLwNYBQYNscUN8HpDnj/W3nJfRsbNBhg9s6YFXJhJoHfZoTjqWFMwKBgQC+kfxEvfBWRSCmDLuWhDQ/83imBNuE1j6AJwHvkzZRuz+YxKjhvGRpwaEvP+2tuKOukiA0OWyG2VPYyq8T8MjcFPaZ4cC022CiW+m1lLG5nhsvSihS+OUgz+rVfmu+Tsh2WD88+WkqruqeA+fIdLcPhG475jeE4KRnSXXXhrdekQKBgF4NpYRdDtKMtZbUykHpppeSLHPUcqcrF/VmdYgT64HzxvW3HZy9vArDDNt0cAyQQidKsvy4tvHtrtGSjDAQPdcENHtBKJHLsiu2vOwD6+q4H/KGQKk3gzSZbnY0lTUDQrXf6mS/xCQ3V+Bmz7qXtAeTq9K2F9KjwzDrqZu9TtubAoGAJvZD5G4M8CZr+WcLB0f6QsTtesvtcag32Q2gmLG5XlZxNzOl75kL0o9y++0PFAB2/p8DlInVBXDzcpRl3SbSeiSTEn0UYCWmCSvPiX9gIroPhsibm/MlLWM0+PdC4gLLe16pdzbq6H4gm7PitJogPzztKLP1z+X51uAvBqSVYvECgYBFasboCACJxPnYDtCd7NlM5JfSMxGofoIKOpqxvAXbBiUuVRO2A9qF1HrXTIbQePelu0xHr7nPLMNAKVsBpn1C8z+J/rmvRQO7THMoGGkFpQuThlILXI+4uGduSVHuO39X8e6oYGHJuYJuByQdBCTh+sOyYdpSCzKsaKurcHljSw==";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm
	// 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmyjJ8O9lSQLNZcRak01hWaaaVDzlfYjP4J47gJX/kyhUDw9J49sxt83B/EoeRW0+6o4fW+TBgJukQrqwatNKR9dJCY8ucW5nIUZilEJfrsUBprJOTanKCTttzTZ44jeoU31S+kcuvXeAXzK7zGVE24yXIG1XRfPqO/axx7u1teFMTWVqJ+4K3uT7zPwtZY4fxbLo59BLPPbWDyhBzuwHFJIqmIx9Jti80HUvcrqr3iZfptYDWJFo6C/5ImoDT+MqWnJAL/uev6Sg0W5d5MUHzS1D4GNjBVzr4E5LsAY4ckVeke1CAA/ohT9TGTjGGYyEQGui1kK6uZzfD5iSR4+IgQIDAQAB";

	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/DropBox/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/DropBox/becomeMember.form";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	// 支付宝网关
	public static String log_path = "C:\\";

	// ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	/**
	 * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
	 * 
	 * @param sWord
	 *            要写入日志里的文本内容
	 */
	public static void logResult(String sWord) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(log_path + "alipay_log_"
					+ System.currentTimeMillis() + ".txt");
			writer.write(sWord);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
