package com.projeto.web.swagger;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.projeto.models.data.ClienteRequest;
import com.projeto.models.data.ClienteResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cliente", description ="Endpoints para o gerenciamento dos clientes ")
public interface ClienteRestControllerApi {

	@Operation(summary = "Listar todos os clientes", description = "Listar todos os clientes",responses = {
			@ApiResponse(
						responseCode="200",
						content = {
							@Content(mediaType = "application/jason",
									array = @ArraySchema(schema = @Schema(implementation = ClienteResponse.class))
									)
						}
					),
					@ApiResponse(description = "Bad Request", responseCode = "400", content= @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content= @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content= @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content= @Content)
						 
			})
	public List<ClienteResponse> list();
	
	@Operation(summary = "Lista paginada de todos os clientes", description = "Listagem por pagina dos clientes",responses = {
			@ApiResponse(
					responseCode="200",
					content = {
						@Content(mediaType = "application/jason",
								array = @ArraySchema(schema = @Schema(implementation = ClienteResponse.class))
								)
					}
				),
				@ApiResponse(description = "Bad Request", responseCode = "400", content= @Content),
				@ApiResponse(description = "Unauthorized", responseCode = "401", content= @Content),
				@ApiResponse(description = "Not Found", responseCode = "404", content= @Content),
				@ApiResponse(description = "Internal Error", responseCode = "500", content= @Content)
					 
		})
	public Page<ClienteResponse> listaPaginada(
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
	
	@Operation(summary = "Lista paginada todos os clientes por busca personalizada", description = "Litagem por pagina dos clientes por busca personalizada",responses = {
			@ApiResponse(
					responseCode="200",
					content = {
						@Content(mediaType = "application/jason",
								array = @ArraySchema(schema = @Schema(implementation = ClienteResponse.class))
								)
					}
				),
				@ApiResponse(description = "Bad Request", responseCode = "400", content= @Content),
				@ApiResponse(description = "Unauthorized", responseCode = "401", content= @Content),
				@ApiResponse(description = "Not Found", responseCode = "404", content= @Content),
				@ApiResponse(description = "Internal Error", responseCode = "500", content= @Content)
					 
		})
	public Page<ClienteResponse> listaPagiadaPornome(
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
	
	@Operation(summary = "Busca de clientes por ID", description = "Busca de clientes por ID",responses = {
			@ApiResponse(
					responseCode="200",
					content = {
						@Content(mediaType = "application/jason",
								array = @ArraySchema(schema = @Schema(implementation = ClienteResponse.class))
								)
					}
				),
				@ApiResponse(description = "Bad Request", responseCode = "400", content= @Content),
				@ApiResponse(description = "Unauthorized", responseCode = "401", content= @Content),
				@ApiResponse(description = "Not Found", responseCode = "404", content= @Content),
				@ApiResponse(description = "Internal Error", responseCode = "500", content= @Content),
				@ApiResponse(description = "No Content", responseCode = "204", content= @Content)
		})
	public ResponseEntity<?> buscarClientePorId(@Parameter(description = "id de um cliente",
														   example ="1",
														   required = true)
														   Long id);
	
	@Operation(summary = "Cadastrar um cliente", description = "Necessita de todos os cadastros validos",responses = {
			@ApiResponse(
					responseCode="200",
					content = {
						@Content(mediaType = "application/jason",
								array = @ArraySchema(schema = @Schema(implementation = ClienteResponse.class))
								)
					}
				),
				@ApiResponse(description = "Bad Request", responseCode = "400", content= @Content),
				@ApiResponse(description = "Unauthorized", responseCode = "401", content= @Content),
				@ApiResponse(description = "Internal Error", responseCode = "500", content= @Content)
		})
	public ResponseEntity<?> salvarCliente(
			@RequestBody(description ="Representação de um cliente",
			required = true)
			ClienteRequest usuario);
	
	@Operation(summary = "Alterar um cliente por ID", description = "Necessita de todos os cadastros validos",responses = {
			@ApiResponse(
					responseCode="200",
					content = {
						@Content(mediaType = "application/jason",
								array = @ArraySchema(schema = @Schema(implementation = ClienteResponse.class))
								)
					}
				),
				@ApiResponse(description = "Bad Request", responseCode = "400", content= @Content),
				@ApiResponse(description = "Unauthorized", responseCode = "401", content= @Content),
				@ApiResponse(description = "Not Found", responseCode = "404", content= @Content),
				@ApiResponse(description = "Internal Error", responseCode = "500", content= @Content)
		})
	public ResponseEntity<?> alterarCliente(
			@Parameter(description = "id de cliente",
			example = "1",
			required = true)
			Long id, 
			@RequestBody(description = "Representação de um cliente existente",
			required = true)
			ClienteRequest cliente);
	
	@Operation(summary = "Excluir um cliente por ID", description = "Necessita de um ID valido",responses = {
			@ApiResponse(
					responseCode="200",
					content = {
						@Content(mediaType = "application/jason",
								array = @ArraySchema(schema = @Schema(implementation = ClienteResponse.class))
								)
					}
				),
				@ApiResponse(description = "Bad Request", responseCode = "400", content= @Content),
				@ApiResponse(description = "Unauthorized", responseCode = "401", content= @Content),
				@ApiResponse(description = "Not Found", responseCode = "404", content= @Content),
				@ApiResponse(description = "Internal Error", responseCode = "500", content= @Content),
				@ApiResponse(description = "No Content", responseCode = "204", content= @Content)
		})
	public ResponseEntity<?> excluirCliente(
			@Parameter(description = "id de cliente",
			example = "1",
			required = true)
			Long id);
	
	
}