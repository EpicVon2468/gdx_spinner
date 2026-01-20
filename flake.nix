{
	description = "A port of YarnSpinner for libGDX";

	inputs = {
		nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable";
    flake-utils.url = "github:numtide/flake-utils";
	};

	outputs = { self, nixpkgs, flake-utils }:
		flake-utils.lib.eachDefaultSystem(system:
			let
				pkgs = import nixpkgs { inherit system; };
				protobuf = pkgs.protobuf;
			in {
				devShells.default = pkgs.mkShellNoCC {
        	buildInputs = with pkgs; [
        		protobuf
        	];
        };
			}
		);
}