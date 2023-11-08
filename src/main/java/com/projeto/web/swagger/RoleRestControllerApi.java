package com.projeto.web.swagger;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.projeto.models.model.Role;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Role", description ="Endpoints para o gerenciamento dos direitos de acesso")
public interface RoleRestControllerApi {

	@Operation(summary = "Listar todos os direitos de acesso", description = "Listar todos os direitos de acesso",responses = {
			@ApiResponse(
						responseCode="200",
						content = {
							@Content(mediaType = "application/jason",
									array = @ArraySchema(schema = @Schema(implementation = Role.class))
									)
						}
					),
					@ApiResponse(description = "Bad Request", responseCode = "400", content= @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content= @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content= @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content= @Content)
						 
			})
	public List<Role> lista();
	@Operation(summary = "Listar paginas", description = "Listar paginas",responses = {
			@ApiResponse(
						responseCode="200",
						content = {
							@Content(mediaType = "application/jason",
									array = @ArraySchema(schema = @Schema(implementation = Role.class))
									)
						}
					),
					@ApiResponse(description = "Bad Request", responseCode = "400", content= @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content= @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content= @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content= @Content)
						 
			})
	public Page<Role> listaPaginada(
			@Parameter(description = "numero da pagina",
			example = "1",
			required = true)
			Integer page,
			@Parameter(description = "quantidade de registro por pagina",
			example = "10",
			required = true)
			Integer pageSize,
			@Parameter(description = "ordem de classificação 'asc' ou 'desc'",
			example = "asc",
			required = true)
			String dir,
			@Parameter(description = "atributo (campo) para ordenação",
			example = "username",
			required = true)
			String props);
	
	@Operation(summary = "Lista paginada por nome", description = "Lista paginada por nome",responses = {
			@ApiResponse(
						responseCode="200",
						content = {
							@Content(mediaType = "application/jason",
									array = @ArraySchema(schema = @Schema(implementation = Role.class))
									)
						}
					),
					@ApiResponse(description = "Bad Request", responseCode = "400", content= @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content= @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content= @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content= @Content)
						 
			})
	public Page<Role> listaPagiadaPornome(@Parameter(description = "numero da pagina",
			example = "1",
			required = true)
			Integer page,
			@Parameter(description = "quantidade de registro por pagina",
			example = "10",
			required = true)
			Integer pageSize,
			@Parameter(description = "ordem de classificação 'asc' ou 'desc'",
			example = "asc",
			required = true)
			String dir,
			@Parameter(description = "atributo (campo) para ordenação",
			example = "username",
			required = true)
			String props);
	
	
	@Operation(summary = "Busca de direitos de acesso por ID", description = "Busca de direitas de acesso por ID",responses = {
			@ApiResponse(
					responseCode="200",
					content = {
						@Content(mediaType = "application/jason",
								array = @ArraySchema(schema = @Schema(implementation = Role.class))
								)
					}
				),
				@ApiResponse(description = "Bad Request", responseCode = "400", content= @Content),
				@ApiResponse(description = "Unauthorized", responseCode = "401", content= @Content),
				@ApiResponse(description = "Not Found", responseCode = "404", content= @Content),
				@ApiResponse(description = "Internal Error", responseCode = "500", content= @Content),
				@ApiResponse(description = "No Content", responseCode = "204", content= @Content)
		})
	public ResponseEntity<?> buscarRolePorId(@Parameter(description = "id de um direito de acesso",
											example ="1",
											required = true)
											Long id);
	
	@Operation(summary = "Cadastrar um direito de acesso", description = "Necessita de todos os cadastros validos",responses = {
			@ApiResponse(
					responseCode="200",
					content = {
						@Content(mediaType = "application/jason",
								array = @ArraySchema(schema = @Schema(implementation = Role.class))
								)
					}
				),
				@ApiResponse(description = "Bad Request", responseCode = "400", content= @Content),
				@ApiResponse(description = "Unauthorized", responseCode = "401", content= @Content),
				@ApiResponse(description = "Internal Error", responseCode = "500", content= @Content)
		})
	public ResponseEntity<?> salvarRole(
			@RequestBody(description ="Representação de um direito de acesso",
			required = true)
			Role role);
	
	@Operation(summary = "Alterar os direitos de acesso por ID", description = "Necessita de todos os cadastros validos",responses = {
			@ApiResponse(
					responseCode="200",
					content = {
						@Content(mediaType = "application/jason",
								array = @ArraySchema(schema = @Schema(implementation = Role.class))
								)
					}
				),
				@ApiResponse(description = "Bad Request", responseCode = "400", content= @Content),
				@ApiResponse(description = "Unauthorized", responseCode = "401", content= @Content),
				@ApiResponse(description = "Not Found", responseCode = "404", content= @Content),
				@ApiResponse(description = "Internal Error", responseCode = "500", content= @Content)
		})
	public ResponseEntity<?> alterarRole(@Parameter(description = "id de direito de acesso",
			example = "1",
			required = true)
			Long id, 
			@RequestBody(description = "Representação de um direito de acesso existente dos usuarios",
			required = true)
			Role role);
	
	@Operation(summary = "Excluir um direito de acesso por ID", description = "Necessita de um ID valido",responses = {
			@ApiResponse(
					responseCode="200",
					content = {
						@Content(mediaType = "application/jason",
								array = @ArraySchema(schema = @Schema(implementation = Role.class))
								)
					}
				),
				@ApiResponse(description = "Bad Request", responseCode = "400", content= @Content),
				@ApiResponse(description = "Unauthorized", responseCode = "401", content= @Content),
				@ApiResponse(description = "Not Found", responseCode = "404", content= @Content),
				@ApiResponse(description = "Internal Error", responseCode = "500", content= @Content),
				@ApiResponse(description = "No Content", responseCode = "204", content= @Content)
		})
	public ResponseEntity<?> excluirRole(
			@Parameter(description = "id de um direito de acesso",
			example = "1",
			required = true)
			Long id);

	
}