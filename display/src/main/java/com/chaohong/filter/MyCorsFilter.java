package com.chaohong.filter;

import com.chaohong.Utils.CorsUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


public class MyCorsFilter extends CorsFilter {

//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept,dwt-md5");
//		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
//		response.setHeader("Access-Control-Max-Age", "3600");
//		response.setHeader("Access-Control-Allow-Credentials", "true");
//		response.setHeader("Allow", "POST, PATCH, GET, DELETE");
//		filterChain.doFilter(request, response);
//
//	}

    /**
     * Constructor accepting a {@link CorsConfigurationSource} used by the filter
     * to find the {@link CorsConfiguration} to use for each incoming request.
     *
     * @see UrlBasedCorsConfigurationSource
     */
    public MyCorsFilter() {
        super(MyCorsFilter.getConfig());
    }

    private static CorsConfigurationSource getConfig() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        //allow-credentials="true"
        config.setAllowCredentials(true);
        //allowed-origins="*"
        CorsUtils.setAllowedOrigin(config);
        //max-age="3600"
        config.setMaxAge(3600L);
        //"Content-Type, X-Requested-With, accept, Origin, Access-Control-Request-Method, Access-Control-Request-Headers"
        config.addAllowedHeader("*");
        //"POST, GET, PUT, OPTIONS, DELETE"
        config.addAllowedMethod("*");
        //mapping path="/**"
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
