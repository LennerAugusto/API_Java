package com.projeto.web.swagger;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.projeto.models.data.ClienteRequest;
import com.projeto.models.data.ClienteResponse;
import com.projeto.models.data.ProdutoRequest;
import com.projeto.models.data.ProdutoResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Produto", description ="Endpoints para o gerenciamento dos produtos")
public interface ProdutoRestControllerApi {

	@Operation(summary = "Listar todos os produtos", description = "Listar todos os produtos",responses = {
			@ApiResponse(
						responseCode="200",
						content = {
							@Content(mediaType = "application/jason",
									array = @ArraySchema(schema = @Schema(implementation = ProdutoResponse.class))
									)
						}
					),
					@ApiResponse(description = "Bad Request", responseCode = "400", content= @Content),
					@ApiResponse(description = "Unauthorized", responseCode = "401", content= @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content= @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content= @Content)
						 
			})
	
	public ResponseEntity<?> buscarProdutoPorId(@Parameter(description = "id de um produto",
														   example ="1",
														   required = true)
														   Long id);
	
	@Operation(summary = "Cadastrar um produto", description = "Necessita de todos os cadastros validos",responses = {
			@ApiResponse(
					responseCode="200",
					content = {
						@Content(mediaType = "application/jason",
								array = @ArraySchema(schema = @Schema(implementation = ProdutoResponse.class))
								)
					}
				),
				@ApiResponse(description = "Bad Request", responseCode = "400", content= @Content),
				@ApiResponse(description = "Unauthorized", responseCode = "401", content= @Content),
				@ApiResponse(description = "Internal Error", responseCode = "500", content= @Content)
		})
	public ResponseEntity<?> salvarCliente(
			@RequestBody(description ="Representação de um produto",
			required = true)
			ProdutoRequest produto);
	
	@Operation(summary = "Alterar um produto por ID", description = "Necessita de todos os cadastros validos",responses = {
			@ApiResponse(
					responseCode="200",
					content = {
						@Content(mediaType = "application/jason",
								array = @ArraySchema(schema = @Schema(implementation = ProdutoResponse.class))
								)
					}
				),
				@ApiResponse(description = "Bad Request", responseCode = "400", content= @Content),
				@ApiResponse(description = "Unauthorized", responseCode = "401", content= @Content),
				@ApiResponse(description = "Not Found", responseCode = "404", content= @Content),
				@ApiResponse(description = "Internal Error", responseCode = "500", content= @Content)
		})
	public ResponseEntity<?> alterarProduto(
			@Parameter(description = "id de produto",
			example = "1",
			required = true)
			Long id, 
			@RequestBody(description = "Representação de um produto existente",
			required = true)
			ProdutoRequest produto);
	
	@Operation(summary = "Excluir um produto por ID", description = "Necessita de um ID valido",responses = {
			@ApiResponse(
					responseCode="200",
					content = {
						@Content(mediaType = "application/jason",
								array = @ArraySchema(schema = @Schema(implementation = ProdutoResponse.class))
								)
					}
				),
				@ApiResponse(description = "Bad Request", responseCode = "400", content= @Content),
				@ApiResponse(description = "Unauthorized", responseCode = "401", content= @Content),
				@ApiResponse(description = "Not Found", responseCode = "404", content= @Content),
				@ApiResponse(description = "Internal Error", responseCode = "500", content= @Content),
				@ApiResponse(description = "No Content", responseCode = "204", content= @Content)
		})
	public ResponseEntity<?> excluirProduto(
			@Parameter(description = "id de produto",
			example = "1",
			required = true)
			Long id);
	
	
}