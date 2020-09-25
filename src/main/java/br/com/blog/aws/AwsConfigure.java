package br.com.blog.aws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AwsConfigure {

	  private static final String AWSID = "AKIA3QGP4WCSNP3WSLMI";
	 
	  private static final String AWSKEY = "uUOJMlSCxb8Yg2HwNB5Ejzbzo2YEV4uffSBGrua+";
	  
	  private static final String REGION = "us-west-1";
	  
	  private static final String BUCKET = "eventarea";
	  
	  private static final String URLPadrao = "https://eventarea.s3-us-west-1.amazonaws.com/";
	  
	  //Retornar Cliente Padrão
	  @Bean
	  public AmazonS3 s3client() {
	    BasicAWSCredentials awsCreds = new BasicAWSCredentials(AWSID, AWSKEY);
	    AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
	                			.withRegion(REGION)
	                				.withCredentials(new AWSStaticCredentialsProvider(awsCreds)).build();
	    return s3Client;
	  }

	public String getBucket() {
		return BUCKET;
	}
	
	public String getUrlPadrao() {
		return URLPadrao;
	}
}
